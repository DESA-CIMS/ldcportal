/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.un.ldcportal.ismapplications.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.un.ldcportal.ismapplications.NoSuchISMException;
import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.model.impl.ISMImpl;
import org.un.ldcportal.ismapplications.model.impl.ISMModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the i s m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMPersistence
 * @see ISMUtil
 * @generated
 */
public class ISMPersistenceImpl extends BasePersistenceImpl<ISM>
	implements ISMPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ISMUtil} to access the i s m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ISMImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ISMModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			ISMModelImpl.GROUPID_COLUMN_BITMASK |
			ISMModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_WEBCONTENDID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWebContendId",
			new String[] { Long.class.getName() },
			ISMModelImpl.WEBCONTENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBCONTENDID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWebContendId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_I = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_I",
			new String[] { Long.class.getName(), Long.class.getName() },
			ISMModelImpl.ISMID_COLUMN_BITMASK |
			ISMModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_I = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_I",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_ISMID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByismId",
			new String[] { Long.class.getName() },
			ISMModelImpl.ISMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISMID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByismId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MBCATEGORYID =
		new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymbCategoryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MBCATEGORYID =
		new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymbCategoryId",
			new String[] { Long.class.getName() },
			ISMModelImpl.MBCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MBCATEGORYID = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymbCategoryId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, ISMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the i s m in the entity cache if it is enabled.
	 *
	 * @param ism the i s m
	 */
	public void cacheResult(ISM ism) {
		EntityCacheUtil.putResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMImpl.class, ism.getPrimaryKey(), ism);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
			new Object[] { Long.valueOf(ism.getWebContentId()) }, ism);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
			new Object[] {
				Long.valueOf(ism.getIsmId()), Long.valueOf(ism.getGroupId())
			}, ism);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISMID,
			new Object[] { Long.valueOf(ism.getIsmId()) }, ism);

		ism.resetOriginalValues();
	}

	/**
	 * Caches the i s ms in the entity cache if it is enabled.
	 *
	 * @param isms the i s ms
	 */
	public void cacheResult(List<ISM> isms) {
		for (ISM ism : isms) {
			if (EntityCacheUtil.getResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
						ISMImpl.class, ism.getPrimaryKey()) == null) {
				cacheResult(ism);
			}
			else {
				ism.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all i s ms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ISMImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ISMImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the i s m.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ISM ism) {
		EntityCacheUtil.removeResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMImpl.class, ism.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ism);
	}

	@Override
	public void clearCache(List<ISM> isms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ISM ism : isms) {
			EntityCacheUtil.removeResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
				ISMImpl.class, ism.getPrimaryKey());

			clearUniqueFindersCache(ism);
		}
	}

	protected void clearUniqueFindersCache(ISM ism) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
			new Object[] { Long.valueOf(ism.getWebContentId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I,
			new Object[] {
				Long.valueOf(ism.getIsmId()), Long.valueOf(ism.getGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISMID,
			new Object[] { Long.valueOf(ism.getIsmId()) });
	}

	/**
	 * Creates a new i s m with the primary key. Does not add the i s m to the database.
	 *
	 * @param ismId the primary key for the new i s m
	 * @return the new i s m
	 */
	public ISM create(long ismId) {
		ISM ism = new ISMImpl();

		ism.setNew(true);
		ism.setPrimaryKey(ismId);

		return ism;
	}

	/**
	 * Removes the i s m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ismId the primary key of the i s m
	 * @return the i s m that was removed
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM remove(long ismId) throws NoSuchISMException, SystemException {
		return remove(Long.valueOf(ismId));
	}

	/**
	 * Removes the i s m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the i s m
	 * @return the i s m that was removed
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ISM remove(Serializable primaryKey)
		throws NoSuchISMException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ISM ism = (ISM)session.get(ISMImpl.class, primaryKey);

			if (ism == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchISMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ism);
		}
		catch (NoSuchISMException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ISM removeImpl(ISM ism) throws SystemException {
		ism = toUnwrappedModel(ism);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ism);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ism);

		return ism;
	}

	@Override
	public ISM updateImpl(org.un.ldcportal.ismapplications.model.ISM ism,
		boolean merge) throws SystemException {
		ism = toUnwrappedModel(ism);

		boolean isNew = ism.isNew();

		ISMModelImpl ismModelImpl = (ISMModelImpl)ism;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ism, merge);

			ism.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ISMModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(ismModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalGroupId()),
						Long.valueOf(ismModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);

				args = new Object[] {
						Long.valueOf(ismModelImpl.getGroupId()),
						Long.valueOf(ismModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);
			}

			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MBCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalMbCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MBCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MBCATEGORYID,
					args);

				args = new Object[] { Long.valueOf(ismModelImpl.getMbCategoryId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MBCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MBCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
			ISMImpl.class, ism.getPrimaryKey(), ism);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
				new Object[] { Long.valueOf(ism.getWebContentId()) }, ism);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
				new Object[] {
					Long.valueOf(ism.getIsmId()), Long.valueOf(ism.getGroupId())
				}, ism);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISMID,
				new Object[] { Long.valueOf(ism.getIsmId()) }, ism);
		}
		else {
			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WEBCONTENDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalWebContentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WEBCONTENDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
					new Object[] { Long.valueOf(ism.getWebContentId()) }, ism);
			}

			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalIsmId()),
						Long.valueOf(ismModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
					new Object[] {
						Long.valueOf(ism.getIsmId()),
						Long.valueOf(ism.getGroupId())
					}, ism);
			}

			if ((ismModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ISMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ismModelImpl.getOriginalIsmId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISMID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISMID,
					new Object[] { Long.valueOf(ism.getIsmId()) }, ism);
			}
		}

		return ism;
	}

	protected ISM toUnwrappedModel(ISM ism) {
		if (ism instanceof ISMImpl) {
			return ism;
		}

		ISMImpl ismImpl = new ISMImpl();

		ismImpl.setNew(ism.isNew());
		ismImpl.setPrimaryKey(ism.getPrimaryKey());

		ismImpl.setIsmId(ism.getIsmId());
		ismImpl.setWebContentId(ism.getWebContentId());
		ismImpl.setModeratorId(ism.getModeratorId());
		ismImpl.setCompanyId(ism.getCompanyId());
		ismImpl.setGroupId(ism.getGroupId());
		ismImpl.setMbCategoryId(ism.getMbCategoryId());
		ismImpl.setAssetCategoryId(ism.getAssetCategoryId());

		return ismImpl;
	}

	/**
	 * Returns the i s m with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the i s m
	 * @return the i s m
	 * @throws com.liferay.portal.NoSuchModelException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ISM findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the i s m with the primary key or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	 *
	 * @param ismId the primary key of the i s m
	 * @return the i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByPrimaryKey(long ismId)
		throws NoSuchISMException, SystemException {
		ISM ism = fetchByPrimaryKey(ismId);

		if (ism == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ismId);
			}

			throw new NoSuchISMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ismId);
		}

		return ism;
	}

	/**
	 * Returns the i s m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the i s m
	 * @return the i s m, or <code>null</code> if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ISM fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the i s m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ismId the primary key of the i s m
	 * @return the i s m, or <code>null</code> if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByPrimaryKey(long ismId) throws SystemException {
		ISM ism = (ISM)EntityCacheUtil.getResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
				ISMImpl.class, ismId);

		if (ism == _nullISM) {
			return null;
		}

		if (ism == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ism = (ISM)session.get(ISMImpl.class, Long.valueOf(ismId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ism != null) {
					cacheResult(ism);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ISMModelImpl.ENTITY_CACHE_ENABLED,
						ISMImpl.class, ismId, _nullISM);
				}

				closeSession(session);
			}
		}

		return ism;
	}

	/**
	 * Returns all the i s ms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ISM> list = (List<ISM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first i s m in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		List<ISM> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last i s m in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		int count = countByGroupId(groupId);

		List<ISM> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the i s ms before and after the current i s m in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ismId the primary key of the current i s m
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM[] findByGroupId_PrevAndNext(long ismId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		ISM ism = findByPrimaryKey(ismId);

		Session session = null;

		try {
			session = openSession();

			ISM[] array = new ISMImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, ism, groupId,
					orderByComparator, true);

			array[1] = ism;

			array[2] = getByGroupId_PrevAndNext(session, ism, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ISM getByGroupId_PrevAndNext(Session session, ISM ism,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ISM_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ism);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ISM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the i s ms that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ISMImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ISMImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the i s ms before and after the current i s m in the ordered set of i s ms that the user has permission to view where groupId = &#63;.
	 *
	 * @param ismId the primary key of the current i s m
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM[] filterFindByGroupId_PrevAndNext(long ismId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(ismId, groupId, orderByComparator);
		}

		ISM ism = findByPrimaryKey(ismId);

		Session session = null;

		try {
			session = openSession();

			ISM[] array = new ISMImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, ism, groupId,
					orderByComparator, true);

			array[1] = ism;

			array[2] = filterGetByGroupId_PrevAndNext(session, ism, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ISM filterGetByGroupId_PrevAndNext(Session session, ISM ism,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ISMImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ISMImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ism);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ISM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the i s ms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByG_C(long groupId, long companyId)
		throws SystemException {
		return findByG_C(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByG_C(long groupId, long companyId, int start, int end)
		throws SystemException {
		return findByG_C(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findByG_C(long groupId, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ISM> list = (List<ISM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByG_C_First(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		List<ISM> list = findByG_C(groupId, companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByG_C_Last(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		int count = countByG_C(groupId, companyId);

		List<ISM> list = findByG_C(groupId, companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the i s ms before and after the current i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ismId the primary key of the current i s m
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM[] findByG_C_PrevAndNext(long ismId, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		ISM ism = findByPrimaryKey(ismId);

		Session session = null;

		try {
			session = openSession();

			ISM[] array = new ISMImpl[3];

			array[0] = getByG_C_PrevAndNext(session, ism, groupId, companyId,
					orderByComparator, true);

			array[1] = ism;

			array[2] = getByG_C_PrevAndNext(session, ism, groupId, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ISM getByG_C_PrevAndNext(Session session, ISM ism, long groupId,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ISM_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ism);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ISM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByG_C(long groupId, long companyId)
		throws SystemException {
		return filterFindByG_C(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByG_C(long groupId, long companyId, int start,
		int end) throws SystemException {
		return filterFindByG_C(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms that the user has permissions to view where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> filterFindByG_C(long groupId, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C(groupId, companyId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ISMImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ISMImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			return (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the i s ms before and after the current i s m in the ordered set of i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param ismId the primary key of the current i s m
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM[] filterFindByG_C_PrevAndNext(long ismId, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(ismId, groupId, companyId,
				orderByComparator);
		}

		ISM ism = findByPrimaryKey(ismId);

		Session session = null;

		try {
			session = openSession();

			ISM[] array = new ISMImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(session, ism, groupId,
					companyId, orderByComparator, true);

			array[1] = ism;

			array[2] = filterGetByG_C_PrevAndNext(session, ism, groupId,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ISM filterGetByG_C_PrevAndNext(Session session, ISM ism,
		long groupId, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ISMImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ISMImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ism);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ISM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the i s m where webContentId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	 *
	 * @param webContentId the web content ID
	 * @return the matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByWebContendId(long webContentId)
		throws NoSuchISMException, SystemException {
		ISM ism = fetchByWebContendId(webContentId);

		if (ism == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("webContentId=");
			msg.append(webContentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchISMException(msg.toString());
		}

		return ism;
	}

	/**
	 * Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param webContentId the web content ID
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByWebContendId(long webContentId) throws SystemException {
		return fetchByWebContendId(webContentId, true);
	}

	/**
	 * Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param webContentId the web content ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByWebContendId(long webContentId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { webContentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_WEBCONTENDID_WEBCONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webContentId);

				List<ISM> list = q.list();

				result = list;

				ISM ism = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
						finderArgs, list);
				}
				else {
					ism = list.get(0);

					cacheResult(ism);

					if ((ism.getWebContentId() != webContentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
							finderArgs, ism);
					}
				}

				return ism;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WEBCONTENDID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ISM)result;
			}
		}
	}

	/**
	 * Returns the i s m where ismId = &#63; and groupId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	 *
	 * @param ismId the ism ID
	 * @param groupId the group ID
	 * @return the matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByG_I(long ismId, long groupId)
		throws NoSuchISMException, SystemException {
		ISM ism = fetchByG_I(ismId, groupId);

		if (ism == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ismId=");
			msg.append(ismId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchISMException(msg.toString());
		}

		return ism;
	}

	/**
	 * Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ismId the ism ID
	 * @param groupId the group ID
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByG_I(long ismId, long groupId) throws SystemException {
		return fetchByG_I(ismId, groupId, true);
	}

	/**
	 * Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ismId the ism ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByG_I(long ismId, long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ismId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_I,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_G_I_ISMID_2);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ismId);

				qPos.add(groupId);

				List<ISM> list = q.list();

				result = list;

				ISM ism = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
						finderArgs, list);
				}
				else {
					ism = list.get(0);

					cacheResult(ism);

					if ((ism.getIsmId() != ismId) ||
							(ism.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_I,
							finderArgs, ism);
					}
				}

				return ism;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_I,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ISM)result;
			}
		}
	}

	/**
	 * Returns the i s m where ismId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	 *
	 * @param ismId the ism ID
	 * @return the matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findByismId(long ismId)
		throws NoSuchISMException, SystemException {
		ISM ism = fetchByismId(ismId);

		if (ism == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ismId=");
			msg.append(ismId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchISMException(msg.toString());
		}

		return ism;
	}

	/**
	 * Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ismId the ism ID
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByismId(long ismId) throws SystemException {
		return fetchByismId(ismId, true);
	}

	/**
	 * Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ismId the ism ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM fetchByismId(long ismId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ismId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ISMID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_ISMID_ISMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ismId);

				List<ISM> list = q.list();

				result = list;

				ISM ism = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISMID,
						finderArgs, list);
				}
				else {
					ism = list.get(0);

					cacheResult(ism);

					if ((ism.getIsmId() != ismId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISMID,
							finderArgs, ism);
					}
				}

				return ism;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISMID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ISM)result;
			}
		}
	}

	/**
	 * Returns all the i s ms where mbCategoryId = &#63;.
	 *
	 * @param mbCategoryId the mb category ID
	 * @return the matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findBymbCategoryId(long mbCategoryId)
		throws SystemException {
		return findBymbCategoryId(mbCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms where mbCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mbCategoryId the mb category ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findBymbCategoryId(long mbCategoryId, int start, int end)
		throws SystemException {
		return findBymbCategoryId(mbCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms where mbCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mbCategoryId the mb category ID
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findBymbCategoryId(long mbCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MBCATEGORYID;
			finderArgs = new Object[] { mbCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MBCATEGORYID;
			finderArgs = new Object[] {
					mbCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<ISM> list = (List<ISM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ISM_WHERE);

			query.append(_FINDER_COLUMN_MBCATEGORYID_MBCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mbCategoryId);

				list = (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first i s m in the ordered set where mbCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mbCategoryId the mb category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findBymbCategoryId_First(long mbCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		List<ISM> list = findBymbCategoryId(mbCategoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mbCategoryId=");
			msg.append(mbCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last i s m in the ordered set where mbCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mbCategoryId the mb category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM findBymbCategoryId_Last(long mbCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		int count = countBymbCategoryId(mbCategoryId);

		List<ISM> list = findBymbCategoryId(mbCategoryId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mbCategoryId=");
			msg.append(mbCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchISMException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the i s ms before and after the current i s m in the ordered set where mbCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ismId the primary key of the current i s m
	 * @param mbCategoryId the mb category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i s m
	 * @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ISM[] findBymbCategoryId_PrevAndNext(long ismId, long mbCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchISMException, SystemException {
		ISM ism = findByPrimaryKey(ismId);

		Session session = null;

		try {
			session = openSession();

			ISM[] array = new ISMImpl[3];

			array[0] = getBymbCategoryId_PrevAndNext(session, ism,
					mbCategoryId, orderByComparator, true);

			array[1] = ism;

			array[2] = getBymbCategoryId_PrevAndNext(session, ism,
					mbCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ISM getBymbCategoryId_PrevAndNext(Session session, ISM ism,
		long mbCategoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ISM_WHERE);

		query.append(_FINDER_COLUMN_MBCATEGORYID_MBCATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mbCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ism);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ISM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the i s ms.
	 *
	 * @return the i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i s ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the i s ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public List<ISM> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ISM> list = (List<ISM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ISM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ISM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ISM>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ISM>)QueryUtil.list(q, getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the i s ms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ISM ism : findByGroupId(groupId)) {
			remove(ism);
		}
	}

	/**
	 * Removes all the i s ms where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C(long groupId, long companyId)
		throws SystemException {
		for (ISM ism : findByG_C(groupId, companyId)) {
			remove(ism);
		}
	}

	/**
	 * Removes the i s m where webContentId = &#63; from the database.
	 *
	 * @param webContentId the web content ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByWebContendId(long webContentId)
		throws NoSuchISMException, SystemException {
		ISM ism = findByWebContendId(webContentId);

		remove(ism);
	}

	/**
	 * Removes the i s m where ismId = &#63; and groupId = &#63; from the database.
	 *
	 * @param ismId the ism ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_I(long ismId, long groupId)
		throws NoSuchISMException, SystemException {
		ISM ism = findByG_I(ismId, groupId);

		remove(ism);
	}

	/**
	 * Removes the i s m where ismId = &#63; from the database.
	 *
	 * @param ismId the ism ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByismId(long ismId)
		throws NoSuchISMException, SystemException {
		ISM ism = findByismId(ismId);

		remove(ism);
	}

	/**
	 * Removes all the i s ms where mbCategoryId = &#63; from the database.
	 *
	 * @param mbCategoryId the mb category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBymbCategoryId(long mbCategoryId)
		throws SystemException {
		for (ISM ism : findBymbCategoryId(mbCategoryId)) {
			remove(ism);
		}
	}

	/**
	 * Removes all the i s ms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ISM ism : findAll()) {
			remove(ism);
		}
	}

	/**
	 * Returns the number of i s ms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_ISM_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of i s ms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C(long groupId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching i s ms that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_C(long groupId, long companyId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, companyId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_ISM_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ISM.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of i s ms where webContentId = &#63;.
	 *
	 * @param webContentId the web content ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWebContendId(long webContentId) throws SystemException {
		Object[] finderArgs = new Object[] { webContentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WEBCONTENDID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_WEBCONTENDID_WEBCONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(webContentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WEBCONTENDID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms where ismId = &#63; and groupId = &#63;.
	 *
	 * @param ismId the ism ID
	 * @param groupId the group ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_I(long ismId, long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { ismId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_I,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_G_I_ISMID_2);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ismId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_I, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms where ismId = &#63;.
	 *
	 * @param ismId the ism ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countByismId(long ismId) throws SystemException {
		Object[] finderArgs = new Object[] { ismId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_ISMID_ISMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ismId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISMID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms where mbCategoryId = &#63;.
	 *
	 * @param mbCategoryId the mb category ID
	 * @return the number of matching i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countBymbCategoryId(long mbCategoryId) throws SystemException {
		Object[] finderArgs = new Object[] { mbCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MBCATEGORYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISM_WHERE);

			query.append(_FINDER_COLUMN_MBCATEGORYID_MBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mbCategoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MBCATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of i s ms.
	 *
	 * @return the number of i s ms
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ISM);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns all the i s m applications associated with the i s m.
	 *
	 * @param pk the primary key of the i s m
	 * @return the i s m applications associated with the i s m
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk) throws SystemException {
		return getISMApplications(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the i s m applications associated with the i s m.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the i s m
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @return the range of i s m applications associated with the i s m
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end) throws SystemException {
		return getISMApplications(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ISMAPPLICATIONS = new FinderPath(org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.ENTITY_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.FINDER_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl.class,
			org.un.ldcportal.ismapplications.service.persistence.ISMApplicationPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getISMApplications",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the i s m applications associated with the i s m.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the i s m
	 * @param start the lower bound of the range of i s ms
	 * @param end the upper bound of the range of i s ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of i s m applications associated with the i s m
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<org.un.ldcportal.ismapplications.model.ISMApplication> list = (List<org.un.ldcportal.ismapplications.model.ISMApplication>)FinderCacheUtil.getResult(FINDER_PATH_GET_ISMAPPLICATIONS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETISMAPPLICATIONS.concat(ORDER_BY_CLAUSE)
												 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETISMAPPLICATIONS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("ISM_ISMApplication",
					org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.un.ldcportal.ismapplications.model.ISMApplication>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ISMAPPLICATIONS,
						finderArgs);
				}
				else {
					ismApplicationPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ISMAPPLICATIONS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ISMAPPLICATIONS_SIZE = new FinderPath(org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.ENTITY_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.FINDER_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl.class,
			org.un.ldcportal.ismapplications.service.persistence.ISMApplicationPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getISMApplicationsSize", new String[] { Long.class.getName() });

	/**
	 * Returns the number of i s m applications associated with the i s m.
	 *
	 * @param pk the primary key of the i s m
	 * @return the number of i s m applications associated with the i s m
	 * @throws SystemException if a system exception occurred
	 */
	public int getISMApplicationsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ISMAPPLICATIONS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETISMAPPLICATIONSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_ISMAPPLICATIONS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ISMAPPLICATION = new FinderPath(org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.ENTITY_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationModelImpl.FINDER_CACHE_ENABLED,
			org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl.class,
			org.un.ldcportal.ismapplications.service.persistence.ISMApplicationPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsISMApplication",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the i s m application is associated with the i s m.
	 *
	 * @param pk the primary key of the i s m
	 * @param ismApplicationPK the primary key of the i s m application
	 * @return <code>true</code> if the i s m application is associated with the i s m; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsISMApplication(long pk, long ismApplicationPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, ismApplicationPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ISMAPPLICATION,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsISMApplication.contains(pk,
							ismApplicationPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ISMAPPLICATION,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the i s m has any i s m applications associated with it.
	 *
	 * @param pk the primary key of the i s m to check for associations with i s m applications
	 * @return <code>true</code> if the i s m has any i s m applications associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsISMApplications(long pk) throws SystemException {
		if (getISMApplicationsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the i s m persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.un.ldcportal.ismapplications.model.ISM")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ISM>> listenersList = new ArrayList<ModelListener<ISM>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ISM>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsISMApplication = new ContainsISMApplication();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ISMImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ISMPersistence.class)
	protected ISMPersistence ismPersistence;
	@BeanReference(type = ISMApplicationPersistence.class)
	protected ISMApplicationPersistence ismApplicationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsISMApplication containsISMApplication;

	protected class ContainsISMApplication {
		protected ContainsISMApplication() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSISMAPPLICATION,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long ismId, long ismApplicationId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(ismId), new Long(ismApplicationId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_ISM = "SELECT ism FROM ISM ism";
	private static final String _SQL_SELECT_ISM_WHERE = "SELECT ism FROM ISM ism WHERE ";
	private static final String _SQL_COUNT_ISM = "SELECT COUNT(ism) FROM ISM ism";
	private static final String _SQL_COUNT_ISM_WHERE = "SELECT COUNT(ism) FROM ISM ism WHERE ";
	private static final String _SQL_GETISMAPPLICATIONS = "SELECT {ISM_ISMApplication.*} FROM ISM_ISMApplication INNER JOIN ISM_ISM ON (ISM_ISM.ismId = ISM_ISMApplication.ismId) WHERE (ISM_ISM.ismId = ?)";
	private static final String _SQL_GETISMAPPLICATIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ISM_ISMApplication WHERE ismId = ?";
	private static final String _SQL_CONTAINSISMAPPLICATION = "SELECT COUNT(*) AS COUNT_VALUE FROM ISM_ISMApplication WHERE ismId = ? AND ismApplicationId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "ism.groupId = ?";
	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "ism.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_COMPANYID_2 = "ism.companyId = ?";
	private static final String _FINDER_COLUMN_WEBCONTENDID_WEBCONTENTID_2 = "ism.webContentId = ?";
	private static final String _FINDER_COLUMN_G_I_ISMID_2 = "ism.ismId = ? AND ";
	private static final String _FINDER_COLUMN_G_I_GROUPID_2 = "ism.groupId = ?";
	private static final String _FINDER_COLUMN_ISMID_ISMID_2 = "ism.ismId = ?";
	private static final String _FINDER_COLUMN_MBCATEGORYID_MBCATEGORYID_2 = "ism.mbCategoryId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "ism.ismId";
	private static final String _FILTER_SQL_SELECT_ISM_WHERE = "SELECT DISTINCT {ism.*} FROM ISM_ISM ism WHERE ";
	private static final String _FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {ISM_ISM.*} FROM (SELECT DISTINCT ism.ismId FROM ISM_ISM ism WHERE ";
	private static final String _FILTER_SQL_SELECT_ISM_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN ISM_ISM ON TEMP_TABLE.ismId = ISM_ISM.ismId";
	private static final String _FILTER_SQL_COUNT_ISM_WHERE = "SELECT COUNT(DISTINCT ism.ismId) AS COUNT_VALUE FROM ISM_ISM ism WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "ism";
	private static final String _FILTER_ENTITY_TABLE = "ISM_ISM";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ism.";
	private static final String _ORDER_BY_ENTITY_TABLE = "ISM_ISM.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ISM exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ISM exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ISMPersistenceImpl.class);
	private static ISM _nullISM = new ISMImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ISM> toCacheModel() {
				return _nullISMCacheModel;
			}
		};

	private static CacheModel<ISM> _nullISMCacheModel = new CacheModel<ISM>() {
			public ISM toEntityModel() {
				return _nullISM;
			}
		};
}