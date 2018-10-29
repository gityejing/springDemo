package spring_hibernatetemplate_anno.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> {

	private Class<T> EntityClass;// ��ȡʵ����

	@Resource
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		EntityClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	/**
	 * 
	 * ��������: ��ȡ������
	 * 
	 * @param hql
	 * @return
	 */
	public List getManyObjects(String hql) {
		return hibernateTemplate.find(hql);
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
		return hibernateTemplate.find(hql, args);
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
		List list = hibernateTemplate.find(hql, args);
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
		return hibernateTemplate.save(obj);
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
		hibernateTemplate.update(obj);
	}

	/**
	 * 
	 * ��������: ����/����һ��ʵ��
	 * 
	 * @param obj
	 * @return
	 */
	public void merge(Object obj) {
		hibernateTemplate.merge(obj);
	}

	/**
	 * 
	 * ��������: ����/����һ��ʵ��
	 * 
	 * @param obj
	 * @return
	 */
	public void saveOrUpdate(Object obj) {
		hibernateTemplate.saveOrUpdate(obj);
	}

	/**
	 * 
	 * ��������: ɾ��ʵ��
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		hibernateTemplate.delete(obj);
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
			hibernateTemplate.save(list.get(i));
		}
	}

	/**
	 * ��������: ִ��HQL
	 * 
	 * @param hql
	 * @return
	 */
	public int bulkUpdate(String hql) {
		return hibernateTemplate.bulkUpdate(hql);
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
		return hibernateTemplate.bulkUpdate(hql, params);
	}

	/**
	 * 
	 * ��������: ִ��ԭ����ɾ��SQL
	 * 
	 * @param sql
	 */
	public void executeNativeSqlUpdate(final String sql) {
		this.hibernateTemplate.execute(new HibernateCallback() {
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
		this.hibernateTemplate.execute(new HibernateCallback() {
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
		List list = (List) this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createNativeQuery(sql);
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
		return (List) hibernateTemplate.execute(new HibernateCallback() {
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
		Long total = (Long) hibernateTemplate.execute(new HibernateCallback() {
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
		List list = (List) this.hibernateTemplate.execute(new HibernateCallback() {
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
		return (List) hibernateTemplate.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) {
				NativeQuery query = session.createNativeQuery(sql);
				query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
				return query.list();
			}

		});
	}
}
