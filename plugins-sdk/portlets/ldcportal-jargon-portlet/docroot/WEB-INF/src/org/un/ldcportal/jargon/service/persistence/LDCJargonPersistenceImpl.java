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

package org.un.ldcportal.jargon.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
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

import org.un.ldcportal.jargon.NoSuchLDCJargonException;
import org.un.ldcportal.jargon.model.LDCJargon;
import org.un.ldcportal.jargon.model.impl.LDCJargonImpl;
import org.un.ldcportal.jargon.model.impl.LDCJargonModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l d c jargon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see LDCJargonPersistence
 * @see LDCJargonUtil
 * @generated
 */
public class LDCJargonPersistenceImpl extends BasePersistenceImpl<LDCJargon>
	implements LDCJargonPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LDCJargonUtil} to access the l d c jargon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LDCJargonImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, LDCJargonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, LDCJargonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LDCJargonModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, LDCJargonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, LDCJargonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the l d c jargon in the entity cache if it is enabled.
	 *
	 * @param ldcJargon the l d c jargon
	 */
	public void cacheResult(LDCJargon ldcJargon) {
		EntityCacheUtil.putResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonImpl.class, ldcJargon.getPrimaryKey(), ldcJargon);

		ldcJargon.resetOriginalValues();
	}

	/**
	 * Caches the l d c jargons in the entity cache if it is enabled.
	 *
	 * @param ldcJargons the l d c jargons
	 */
	public void cacheResult(List<LDCJargon> ldcJargons) {
		for (LDCJargon ldcJargon : ldcJargons) {
			if (EntityCacheUtil.getResult(
						LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
						LDCJargonImpl.class, ldcJargon.getPrimaryKey()) == null) {
				cacheResult(ldcJargon);
			}
			else {
				ldcJargon.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l d c jargons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LDCJargonImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LDCJargonImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l d c jargon.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LDCJargon ldcJargon) {
		EntityCacheUtil.removeResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonImpl.class, ldcJargon.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LDCJargon> ldcJargons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LDCJargon ldcJargon : ldcJargons) {
			EntityCacheUtil.removeResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
				LDCJargonImpl.class, ldcJargon.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l d c jargon with the primary key. Does not add the l d c jargon to the database.
	 *
	 * @param ldcJargonId the primary key for the new l d c jargon
	 * @return the new l d c jargon
	 */
	public LDCJargon create(long ldcJargonId) {
		LDCJargon ldcJargon = new LDCJargonImpl();

		ldcJargon.setNew(true);
		ldcJargon.setPrimaryKey(ldcJargonId);

		return ldcJargon;
	}

	/**
	 * Removes the l d c jargon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ldcJargonId the primary key of the l d c jargon
	 * @return the l d c jargon that was removed
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon remove(long ldcJargonId)
		throws NoSuchLDCJargonException, SystemException {
		return remove(Long.valueOf(ldcJargonId));
	}

	/**
	 * Removes the l d c jargon with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l d c jargon
	 * @return the l d c jargon that was removed
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDCJargon remove(Serializable primaryKey)
		throws NoSuchLDCJargonException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LDCJargon ldcJargon = (LDCJargon)session.get(LDCJargonImpl.class,
					primaryKey);

			if (ldcJargon == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLDCJargonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ldcJargon);
		}
		catch (NoSuchLDCJargonException nsee) {
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
	protected LDCJargon removeImpl(LDCJargon ldcJargon)
		throws SystemException {
		ldcJargon = toUnwrappedModel(ldcJargon);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ldcJargon);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ldcJargon);

		return ldcJargon;
	}

	@Override
	public LDCJargon updateImpl(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon, boolean merge)
		throws SystemException {
		ldcJargon = toUnwrappedModel(ldcJargon);

		boolean isNew = ldcJargon.isNew();

		LDCJargonModelImpl ldcJargonModelImpl = (LDCJargonModelImpl)ldcJargon;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ldcJargon, merge);

			ldcJargon.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LDCJargonModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ldcJargonModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ldcJargonModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(ldcJargonModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
			LDCJargonImpl.class, ldcJargon.getPrimaryKey(), ldcJargon);

		return ldcJargon;
	}

	protected LDCJargon toUnwrappedModel(LDCJargon ldcJargon) {
		if (ldcJargon instanceof LDCJargonImpl) {
			return ldcJargon;
		}

		LDCJargonImpl ldcJargonImpl = new LDCJargonImpl();

		ldcJargonImpl.setNew(ldcJargon.isNew());
		ldcJargonImpl.setPrimaryKey(ldcJargon.getPrimaryKey());

		ldcJargonImpl.setLdcJargonId(ldcJargon.getLdcJargonId());
		ldcJargonImpl.setName(ldcJargon.getName());
		ldcJargonImpl.setDefinition(ldcJargon.getDefinition());
		ldcJargonImpl.setCompanyId(ldcJargon.getCompanyId());
		ldcJargonImpl.setGroupId(ldcJargon.getGroupId());

		return ldcJargonImpl;
	}

	/**
	 * Returns the l d c jargon with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l d c jargon
	 * @return the l d c jargon
	 * @throws com.liferay.portal.NoSuchModelException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDCJargon findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l d c jargon with the primary key or throws a {@link org.un.ldcportal.jargon.NoSuchLDCJargonException} if it could not be found.
	 *
	 * @param ldcJargonId the primary key of the l d c jargon
	 * @return the l d c jargon
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon findByPrimaryKey(long ldcJargonId)
		throws NoSuchLDCJargonException, SystemException {
		LDCJargon ldcJargon = fetchByPrimaryKey(ldcJargonId);

		if (ldcJargon == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ldcJargonId);
			}

			throw new NoSuchLDCJargonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ldcJargonId);
		}

		return ldcJargon;
	}

	/**
	 * Returns the l d c jargon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l d c jargon
	 * @return the l d c jargon, or <code>null</code> if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LDCJargon fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the l d c jargon with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ldcJargonId the primary key of the l d c jargon
	 * @return the l d c jargon, or <code>null</code> if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon fetchByPrimaryKey(long ldcJargonId)
		throws SystemException {
		LDCJargon ldcJargon = (LDCJargon)EntityCacheUtil.getResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
				LDCJargonImpl.class, ldcJargonId);

		if (ldcJargon == _nullLDCJargon) {
			return null;
		}

		if (ldcJargon == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ldcJargon = (LDCJargon)session.get(LDCJargonImpl.class,
						Long.valueOf(ldcJargonId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ldcJargon != null) {
					cacheResult(ldcJargon);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LDCJargonModelImpl.ENTITY_CACHE_ENABLED,
						LDCJargonImpl.class, ldcJargonId, _nullLDCJargon);
				}

				closeSession(session);
			}
		}

		return ldcJargon;
	}

	/**
	 * Returns all the l d c jargons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l d c jargons where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @return the range of matching l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l d c jargons where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findByGroupId(long groupId, int start, int end,
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

		List<LDCJargon> list = (List<LDCJargon>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_LDCJARGON_WHERE);

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

				list = (List<LDCJargon>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first l d c jargon in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l d c jargon
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a matching l d c jargon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLDCJargonException, SystemException {
		List<LDCJargon> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLDCJargonException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last l d c jargon in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l d c jargon
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a matching l d c jargon could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLDCJargonException, SystemException {
		int count = countByGroupId(groupId);

		List<LDCJargon> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLDCJargonException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the l d c jargons before and after the current l d c jargon in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ldcJargonId the primary key of the current l d c jargon
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l d c jargon
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon[] findByGroupId_PrevAndNext(long ldcJargonId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLDCJargonException, SystemException {
		LDCJargon ldcJargon = findByPrimaryKey(ldcJargonId);

		Session session = null;

		try {
			session = openSession();

			LDCJargon[] array = new LDCJargonImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, ldcJargon, groupId,
					orderByComparator, true);

			array[1] = ldcJargon;

			array[2] = getByGroupId_PrevAndNext(session, ldcJargon, groupId,
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

	protected LDCJargon getByGroupId_PrevAndNext(Session session,
		LDCJargon ldcJargon, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LDCJARGON_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(ldcJargon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LDCJargon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the l d c jargons that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching l d c jargons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l d c jargons that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @return the range of matching l d c jargons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l d c jargons that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l d c jargons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_LDCJARGON_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_2);
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
				LDCJargon.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LDCJargonImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LDCJargonImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LDCJargon>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the l d c jargons before and after the current l d c jargon in the ordered set of l d c jargons that the user has permission to view where groupId = &#63;.
	 *
	 * @param ldcJargonId the primary key of the current l d c jargon
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l d c jargon
	 * @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LDCJargon[] filterFindByGroupId_PrevAndNext(long ldcJargonId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLDCJargonException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(ldcJargonId, groupId,
				orderByComparator);
		}

		LDCJargon ldcJargon = findByPrimaryKey(ldcJargonId);

		Session session = null;

		try {
			session = openSession();

			LDCJargon[] array = new LDCJargonImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, ldcJargon,
					groupId, orderByComparator, true);

			array[1] = ldcJargon;

			array[2] = filterGetByGroupId_PrevAndNext(session, ldcJargon,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LDCJargon filterGetByGroupId_PrevAndNext(Session session,
		LDCJargon ldcJargon, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_LDCJARGON_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_2);
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
				LDCJargon.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LDCJargonImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LDCJargonImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ldcJargon);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LDCJargon> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the l d c jargons.
	 *
	 * @return the l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l d c jargons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @return the range of l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l d c jargons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of l d c jargons
	 * @param end the upper bound of the range of l d c jargons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public List<LDCJargon> findAll(int start, int end,
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

		List<LDCJargon> list = (List<LDCJargon>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LDCJARGON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LDCJARGON;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LDCJargon>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LDCJargon>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the l d c jargons where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (LDCJargon ldcJargon : findByGroupId(groupId)) {
			remove(ldcJargon);
		}
	}

	/**
	 * Removes all the l d c jargons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LDCJargon ldcJargon : findAll()) {
			remove(ldcJargon);
		}
	}

	/**
	 * Returns the number of l d c jargons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LDCJARGON_WHERE);

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
	 * Returns the number of l d c jargons that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching l d c jargons that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LDCJARGON_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LDCJargon.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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
	 * Returns the number of l d c jargons.
	 *
	 * @return the number of l d c jargons
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LDCJARGON);

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
	 * Initializes the l d c jargon persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.un.ldcportal.jargon.model.LDCJargon")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LDCJargon>> listenersList = new ArrayList<ModelListener<LDCJargon>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LDCJargon>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LDCJargonImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LDCJargonPersistence.class)
	protected LDCJargonPersistence ldcJargonPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LDCJARGON = "SELECT ldcJargon FROM LDCJargon ldcJargon";
	private static final String _SQL_SELECT_LDCJARGON_WHERE = "SELECT ldcJargon FROM LDCJargon ldcJargon WHERE ";
	private static final String _SQL_COUNT_LDCJARGON = "SELECT COUNT(ldcJargon) FROM LDCJargon ldcJargon";
	private static final String _SQL_COUNT_LDCJARGON_WHERE = "SELECT COUNT(ldcJargon) FROM LDCJargon ldcJargon WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "ldcJargon.groupId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "ldcJargon.ldcJargonId";
	private static final String _FILTER_SQL_SELECT_LDCJARGON_WHERE = "SELECT DISTINCT {ldcJargon.*} FROM LDCJargon_LDCJargon ldcJargon WHERE ";
	private static final String _FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {LDCJargon_LDCJargon.*} FROM (SELECT DISTINCT ldcJargon.ldcJargonId FROM LDCJargon_LDCJargon ldcJargon WHERE ";
	private static final String _FILTER_SQL_SELECT_LDCJARGON_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN LDCJargon_LDCJargon ON TEMP_TABLE.ldcJargonId = LDCJargon_LDCJargon.ldcJargonId";
	private static final String _FILTER_SQL_COUNT_LDCJARGON_WHERE = "SELECT COUNT(DISTINCT ldcJargon.ldcJargonId) AS COUNT_VALUE FROM LDCJargon_LDCJargon ldcJargon WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "ldcJargon";
	private static final String _FILTER_ENTITY_TABLE = "LDCJargon_LDCJargon";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ldcJargon.";
	private static final String _ORDER_BY_ENTITY_TABLE = "LDCJargon_LDCJargon.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LDCJargon exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LDCJargon exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LDCJargonPersistenceImpl.class);
	private static LDCJargon _nullLDCJargon = new LDCJargonImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LDCJargon> toCacheModel() {
				return _nullLDCJargonCacheModel;
			}
		};

	private static CacheModel<LDCJargon> _nullLDCJargonCacheModel = new CacheModel<LDCJargon>() {
			public LDCJargon toEntityModel() {
				return _nullLDCJargon;
			}
		};
}