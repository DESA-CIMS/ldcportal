package org.un.ldcportal.ismapplications.util;

import java.util.Comparator;

import org.un.ldcportal.ismapplications.model.ISM;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.NoSuchEntryException;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * ISM Comparator by Title
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMTitleComparator implements Comparator<ISM>{

	@Override
	public int compare(ISM ism1, ISM ism2) {

		String title1 = StringPool.BLANK;
		String title2 = StringPool.BLANK;				
		
		try {
			title1 = AssetEntryLocalServiceUtil.getAssetEntry(ism1.getWebContentId()).getTitle();
		}
		catch(NoSuchEntryException e) {		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			title2 = AssetEntryLocalServiceUtil.getAssetEntry(ism2.getWebContentId()).getTitle();
		}
		catch(NoSuchEntryException e) {		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (title1.compareToIgnoreCase(title2) > 0) {
			return 1;
		}
		else if (title1.compareToIgnoreCase(title2) < 0) {
			return -1;
		}
		else {
			return 0;
		}
		
	}

}
