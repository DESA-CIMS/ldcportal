
package com.liferay.portal.util;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.NoSuchGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.InheritableMap;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortletConstants;
import com.liferay.portal.model.impl.LayoutTypePortletImpl;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.journal.asset.JournalArticleAssetRendererFactory;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class CustomPortalImpl extends PortalImpl {

	public String getJournalArticleActualURL(
		long groupId, String mainPath, String friendlyURL, Map<String, String[]> params, Map<String, Object> requestContext)
		throws PortalException, SystemException {

		String articleUrlTitle = friendlyURL.substring(JournalArticleConstants.CANONICAL_URL_SEPARATOR.length());

		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, articleUrlTitle);

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		try {
			Group parentGroup = group.getParentGroup();
			groupId = parentGroup.getGroupId();
		}
		catch (Exception e) {
			
		}

		Layout layout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(journalArticle.getLayoutUuid(), groupId);

		String layoutActualURL = getLayoutActualURL(layout, mainPath);

		InheritableMap<String, String[]> actualParams = new InheritableMap<String, String[]>();

		if (params != null) {
			actualParams.setParentMap(params);
		}

		UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();

		String defaultAssetPublisherPortletId =
			typeSettingsProperties.get(LayoutTypePortletConstants.DEFAULT_ASSET_PUBLISHER_PORTLET_ID);

		String currentDefaultAssetPublisherPortletId = defaultAssetPublisherPortletId;

		if (Validator.isNull(defaultAssetPublisherPortletId)) {
			defaultAssetPublisherPortletId = PortletKeys.ASSET_PUBLISHER + LayoutTypePortletImpl.getFullInstanceSeparator();
		}

		HttpServletRequest request = (HttpServletRequest) requestContext.get("request");

		if (Validator.isNull(currentDefaultAssetPublisherPortletId)) {
			String actualPortletAuthenticationToken =
				AuthTokenUtil.getToken(request, layout.getPlid(), defaultAssetPublisherPortletId);

			actualParams.put("p_p_auth", new String[] {
				actualPortletAuthenticationToken
			});
		}

		actualParams.put("p_p_id", new String[] {
			defaultAssetPublisherPortletId
		});
		actualParams.put("p_p_lifecycle", new String[] {
			"0"
		});

		if (Validator.isNull(currentDefaultAssetPublisherPortletId)) {
			actualParams.put("p_p_state", new String[] {
				WindowState.MAXIMIZED.toString()
			});
		}

		actualParams.put("p_p_mode", new String[] {
			"view"
		});
		actualParams.put("p_j_a_id", new String[] {
			String.valueOf(journalArticle.getId())
		});

		String namespace = getPortletNamespace(defaultAssetPublisherPortletId);

		actualParams.put(namespace + "struts_action", new String[] {
			"/asset_publisher/view_content"
		});
		actualParams.put(namespace + "type", new String[] {
			JournalArticleAssetRendererFactory.TYPE
		});
		actualParams.put(namespace + "urlTitle", new String[] {
			journalArticle.getUrlTitle()
		});

		String queryString = HttpUtil.parameterMapToString(actualParams, false);

		if (layoutActualURL.contains(StringPool.QUESTION)) {
			layoutActualURL = layoutActualURL + StringPool.AMPERSAND + queryString;
		}
		else {
			layoutActualURL = layoutActualURL + StringPool.QUESTION + queryString;
		}

		Locale locale = getLocale(request);

		addPageSubtitle(journalArticle.getTitle(locale), request);
		addPageDescription(journalArticle.getDescription(locale), request);

		List<AssetTag> assetTags =
			AssetTagLocalServiceUtil.getTags(JournalArticle.class.getName(), journalArticle.getPrimaryKey());

		if (!assetTags.isEmpty()) {
			addPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);
		}

		return layoutActualURL;
	}

}
