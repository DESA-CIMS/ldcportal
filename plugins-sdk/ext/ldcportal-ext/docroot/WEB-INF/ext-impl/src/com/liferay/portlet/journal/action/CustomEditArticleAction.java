
package com.liferay.portlet.journal.action;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchStructureException;
import com.liferay.portlet.journal.ArticleContentSizeException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.util.JournalUtil;

public class CustomEditArticleAction extends EditArticleAction {

	protected Object[] updateArticle(ActionRequest actionRequest)
		throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		long groupId = ParamUtil.getLong(uploadPortletRequest, "groupId");

		long classNameId = ParamUtil.getLong(uploadPortletRequest, "classNameId");
		long classPK = ParamUtil.getLong(uploadPortletRequest, "classPK");

		String articleId = ParamUtil.getString(uploadPortletRequest, "articleId");
		boolean autoArticleId = ParamUtil.getBoolean(uploadPortletRequest, "autoArticleId");

		double version = ParamUtil.getDouble(uploadPortletRequest, "version");

		boolean localized = ParamUtil.getBoolean(uploadPortletRequest, "localized");

		String defaultLanguageId = ParamUtil.getString(uploadPortletRequest, "defaultLanguageId");

		Locale defaultLocale = LocaleUtil.fromLanguageId(defaultLanguageId);

		String toLanguageId = ParamUtil.getString(uploadPortletRequest, "toLanguageId");

		Locale toLocale = null;

		String title = StringPool.BLANK;
		String description = StringPool.BLANK;

		if (Validator.isNull(toLanguageId)) {
			title = ParamUtil.getString(uploadPortletRequest, "title_" + defaultLanguageId);
			description = ParamUtil.getString(uploadPortletRequest, "description_" + defaultLanguageId);
		}
		else {
			toLocale = LocaleUtil.fromLanguageId(toLanguageId);

			title = ParamUtil.getString(uploadPortletRequest, "title_" + toLanguageId);
			description = ParamUtil.getString(uploadPortletRequest, "description_" + toLanguageId);
		}

		String content = ParamUtil.getString(uploadPortletRequest, "content");

		Boolean fileItemThresholdSizeExceeded =
			(Boolean) uploadPortletRequest.getAttribute(WebKeys.FILE_ITEM_THRESHOLD_SIZE_EXCEEDED);

		if ((fileItemThresholdSizeExceeded != null) && fileItemThresholdSizeExceeded.booleanValue()) {

			throw new ArticleContentSizeException();
		}

		String type = ParamUtil.getString(uploadPortletRequest, "type");
		String structureId = ParamUtil.getString(uploadPortletRequest, "structureId");
		String templateId = ParamUtil.getString(uploadPortletRequest, "templateId");
		String layoutUuid = ParamUtil.getString(uploadPortletRequest, "layoutUuid");

		// The target page and the article must belong to the same group
		// -- or the target page must be in the parent group

		Layout targetLayout = null;

		try {
			long parentGroupId = GroupLocalServiceUtil.getGroup(groupId).getParentGroupId();
			if (Validator.isNotNull(parentGroupId)) {
				targetLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, parentGroupId);
			}
			else {
				targetLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, groupId);
			}
		}
		catch (Exception e) {		
			targetLayout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(layoutUuid, groupId);
		}		

		if (targetLayout == null) {
			layoutUuid = null;
		}

		int displayDateMonth = ParamUtil.getInteger(uploadPortletRequest, "displayDateMonth");
		int displayDateDay = ParamUtil.getInteger(uploadPortletRequest, "displayDateDay");
		int displayDateYear = ParamUtil.getInteger(uploadPortletRequest, "displayDateYear");
		int displayDateHour = ParamUtil.getInteger(uploadPortletRequest, "displayDateHour");
		int displayDateMinute = ParamUtil.getInteger(uploadPortletRequest, "displayDateMinute");
		int displayDateAmPm = ParamUtil.getInteger(uploadPortletRequest, "displayDateAmPm");

		if (displayDateAmPm == Calendar.PM) {
			displayDateHour += 12;
		}

		int expirationDateMonth = ParamUtil.getInteger(uploadPortletRequest, "expirationDateMonth");
		int expirationDateDay = ParamUtil.getInteger(uploadPortletRequest, "expirationDateDay");
		int expirationDateYear = ParamUtil.getInteger(uploadPortletRequest, "expirationDateYear");
		int expirationDateHour = ParamUtil.getInteger(uploadPortletRequest, "expirationDateHour");
		int expirationDateMinute = ParamUtil.getInteger(uploadPortletRequest, "expirationDateMinute");
		int expirationDateAmPm = ParamUtil.getInteger(uploadPortletRequest, "expirationDateAmPm");
		boolean neverExpire = ParamUtil.getBoolean(uploadPortletRequest, "neverExpire");

		if (expirationDateAmPm == Calendar.PM) {
			expirationDateHour += 12;
		}

		int reviewDateMonth = ParamUtil.getInteger(uploadPortletRequest, "reviewDateMonth");
		int reviewDateDay = ParamUtil.getInteger(uploadPortletRequest, "reviewDateDay");
		int reviewDateYear = ParamUtil.getInteger(uploadPortletRequest, "reviewDateYear");
		int reviewDateHour = ParamUtil.getInteger(uploadPortletRequest, "reviewDateHour");
		int reviewDateMinute = ParamUtil.getInteger(uploadPortletRequest, "reviewDateMinute");
		int reviewDateAmPm = ParamUtil.getInteger(uploadPortletRequest, "reviewDateAmPm");
		boolean neverReview = ParamUtil.getBoolean(uploadPortletRequest, "neverReview");

		if (reviewDateAmPm == Calendar.PM) {
			reviewDateHour += 12;
		}

		boolean indexable = ParamUtil.getBoolean(uploadPortletRequest, "indexable");

		boolean smallImage = ParamUtil.getBoolean(uploadPortletRequest, "smallImage");
		String smallImageURL = ParamUtil.getString(uploadPortletRequest, "smallImageURL");
		File smallFile = uploadPortletRequest.getFile("smallFile");

		Map<String, byte[]> images = getImages(uploadPortletRequest);

		String articleURL = ParamUtil.getString(uploadPortletRequest, "articleURL");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(), actionRequest);

		serviceContext.setAttribute("defaultLanguageId", defaultLanguageId);

		JournalArticle article = null;
		String oldUrlTitle = StringPool.BLANK;

		if (cmd.equals(Constants.ADD)) {
			Map<Locale, String> titleMap = new HashMap<Locale, String>();

			titleMap.put(defaultLocale, title);

			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

			descriptionMap.put(defaultLocale, description);

			if (Validator.isNull(structureId)) {
				content =
					LocalizationUtil.updateLocalization(
						StringPool.BLANK, "static-content", content, defaultLanguageId, defaultLanguageId, true, localized);
			}

			// Add article

			article =
				JournalArticleServiceUtil.addArticle(
					groupId, classNameId, classPK, articleId, autoArticleId, titleMap, descriptionMap, content, type,
					structureId, templateId, layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallFile, images, articleURL,
					serviceContext);

			AssetPublisherUtil.addAndStoreSelection(
				actionRequest, JournalArticle.class.getName(), article.getResourcePrimKey(), -1);
		}
		else {

			// Merge current content with new content

			JournalArticle curArticle = JournalArticleServiceUtil.getArticle(groupId, articleId, version);

			if (Validator.isNull(structureId)) {
				if (!curArticle.isTemplateDriven()) {
					String curContent = StringPool.BLANK;

					curContent = curArticle.getContent();

					if (cmd.equals(Constants.TRANSLATE)) {
						content =
							LocalizationUtil.updateLocalization(
								curContent, "static-content", content, toLanguageId, defaultLanguageId, true, true);
					}
					else {
						content =
							LocalizationUtil.updateLocalization(
								curContent, "static-content", content, defaultLanguageId, defaultLanguageId, true, localized);
					}
				}
			}
			else {
				if (curArticle.isTemplateDriven()) {
					JournalStructure structure = null;

					try {
						structure = JournalStructureLocalServiceUtil.getStructure(groupId, structureId);
					}
					catch (NoSuchStructureException nsse) {
						structure = JournalStructureLocalServiceUtil.getStructure(themeDisplay.getCompanyGroupId(), structureId);
					}

					content = JournalUtil.mergeArticleContent(curArticle.getContent(), content, true);
					content = JournalUtil.removeOldContent(content, structure.getMergedXsd());
				}
			}

			// Update article

			article = JournalArticleServiceUtil.getArticle(groupId, articleId, version);

			Map<Locale, String> titleMap = article.getTitleMap();
			Map<Locale, String> descriptionMap = article.getDescriptionMap();

			String tempOldUrlTitle = article.getUrlTitle();

			if (cmd.equals(Constants.UPDATE)) {
				titleMap.put(defaultLocale, title);
				descriptionMap.put(defaultLocale, description);

				article =
					JournalArticleServiceUtil.updateArticle(
						groupId, articleId, version, titleMap, descriptionMap, content, type, structureId, templateId,
						layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
						expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour, expirationDateMinute,
						neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute,
						neverReview, indexable, smallImage, smallImageURL, smallFile, images, articleURL, serviceContext);
			}
			else if (cmd.equals(Constants.TRANSLATE)) {
				article =
					JournalArticleServiceUtil.updateArticleTranslation(
						groupId, articleId, version, toLocale, title, description, content, images);
			}

			if (!tempOldUrlTitle.equals(article.getUrlTitle())) {
				oldUrlTitle = tempOldUrlTitle;
			}
		}

		// Recent articles

		JournalUtil.addRecentArticle(actionRequest, article);

		// Journal content

		String portletResource = ParamUtil.getString(uploadPortletRequest, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(uploadPortletRequest, portletResource);

			preferences.setValue("groupId", String.valueOf(article.getGroupId()));
			preferences.setValue("articleId", article.getArticleId());

			preferences.store();

			updateContentSearch(actionRequest, portletResource, article.getArticleId());
		}

		return new Object[] {
			article, oldUrlTitle
		};
	}

}
