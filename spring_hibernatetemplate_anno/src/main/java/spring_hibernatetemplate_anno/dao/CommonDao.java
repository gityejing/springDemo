package spring_hibernatetemplate_anno.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao extends HibernateDaoSupport {

	@Resource
	private SessionFactory sessionFactory;

	@PostConstruct
	public void initSessionFactory() {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 
	 * ��������: ��ȡ������
	 * 
	 * @param hql
	 * @return
	 */
	public List getManyObjects(String hql) {
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 
	 * ��������: Ԥ����,������,�õ�������¼
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public List getManyObjects(String hql, Object[] args) {
		return getHibernateTemplate().find(hql, args);
	}

	/**
	 * 
	 * ��������: Ԥ����,���������õ�һ����¼
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object getOneObject(String hql, Object[] args) {
		List list = getHibernateTemplate().find(hql, args);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 
	 * ��������: ����һ����¼
	 * 
	 * @param obj
	 * @return
	 */
	public Object save(Object obj) {
		return getHibernateTemplate().save(obj);
	}

	/**
	 * 
	 * ��������: ���������¼
	 * 
	 * @param objs
	 * @return
	 */
	public List saveAll(List objs) {
		if (objs == null || objs.size() == 0) {
			return null;
		}
		List list = new ArrayList();
		for (Object ob : objs) {
			list.add(save(ob));
		}
		return list;
	}

	/**
	 * 
	 * ��������: ����һ��ʵ��
	 * 
	 * @param obj
	 * @return
	 */
	public void update(Object obj) {
		getHibernateTemplate().update(obj);
	}

	/**
	 * 
	 * ��������: ����/����һ��ʵ��
	 * 
	 * @param obj
	 * @return
	 */
	public void merge(Object obj) {
		getHibernateTemplate().merge(obj);
	}

	/**
	 * 
	 * ��������: ����/����һ��ʵ��
	 * 
	 * @param obj
	 * @return
	 */
	public void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	/**
	 * 
	 * ��������: ɾ��ʵ��
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	/**
	 * 
	 * ��������:���漯�϶���
	 * 
	 * @param list
	 */
	public void saveManyObjects(List list) {
		if (list == null || list.size() == 0) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			getHibernateTemplate().save(list.get(i));
		}
	}

	/**
	 * ��������: ִ��HQL
	 * 
	 * @param hql
	 * @return
	 */
	public int bulkUpdate(String hql) {
		return getHibernateTemplate().bulkUpdate(hql);
	}

	/**
	 * 
	 * ��������: ִ��HQL,������
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public int bulkUpdate(String hql, final Object[] params) {
		return getHibernateTemplate().bulkUpdate(hql, params);
	}

	/**
	 * 
	 * ��������: ִ��ԭ����ɾ��SQL
	 * 
	 * @param sql
	 */
	public void executeNativeSqlUpdate(final String sql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				session.createSQLQuery(sql).executeUpdate();
				return null;
			}
		});
	}

	/**
	 * 
	 * ��������: ִ��ԭ����ɾ��SQL ������
	 * 
	 * @param sql
	 * @param params
	 */
	public void executeNativeSqlUpdate(final String sql, final Object[] params) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createSQLQuery(sql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				query.executeUpdate();
				return null;
			}
		});
	}

	/**
	 * 
	 * ��������: ִ��ԭ����ѯSQL,������
	 * 
	 * @param sql
	 * @return
	 */
	public List executeNativeSqlQuery(final String sql, final Object[] params) {
		List list = (List) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createSQLQuery(sql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		return list;
	}

	/**
	 * 
	 * ��������: ��ҳ��ѯ
	 * 
	 * @param sql
	 * @param firstRow
	 * @param maxRow
	 * @return
	 */
	public List findByPage(final String sql, final int firstRow, final int maxRow) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query q = session.createQuery(sql);
				q.setFirstResult(firstRow);
				q.setMaxResults(maxRow);
				return q.list();
			}

		});

	}

	/**
	 * 
	 * ��������: ��ȡ��ҳ��
	 * 
	 * @param sql
	 * @return
	 */
	public int findTotal(final String sql) {
		Long total = (Long) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				String countHQL = "select count(1) " + sql;
				Query q = session.createQuery(countHQL);
				Long total = (Long) q.uniqueResult();
				return total;
			}

		});
		if (total != null) {
			return total.intValue();
		} else {
			return 0;
		}
	}

	/**
	 * ����ָ����ԭ��SQL�Ͳ��� ��ѯ ���ض�Ӧ��javaʵ��
	 * 
	 * @param sql    ԭ��SQL��ѯ���
	 * @param params SQL��������
	 * @param clazz  ʵ����
	 * @return List
	 */
	public List executeNativeSqlQueryForClass(final String sql, final Object[] params, final Class clazz) {
		List list = (List) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql).addEntity(clazz);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		return list;
	}

	/**
	 * 
	 * ��������:ִ��ԭ��sql ��ѯ ����List<map>�� �ṹ
	 * 
	 * @param sql
	 * @return
	 */
	public List findMapBySql(final String sql) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) {
				NativeQuery query = session.createNativeQuery(sql);
				query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
				return query.list();
			}

		});
	}

}