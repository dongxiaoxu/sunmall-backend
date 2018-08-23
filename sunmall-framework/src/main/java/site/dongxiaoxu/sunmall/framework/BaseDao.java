package site.dongxiaoxu.sunmall.framework;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import site.dongxiaoxu.sunmall.framework.exception.BaseDaoException;

import java.util.List;
import java.util.Map;

/**
 * Created by dongxu on 2018/8/22.
 */
@Repository
public class BaseDao<T> extends HibernateDaoSupport{
        @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    /**
     *
     * <p>Description: 保存一个model到数据库，功能类似于insert into table</p>
     * @param t model对象
     * @throws BaseDaoException 数据访问异常
     */
    public void save(T t) throws BaseDaoException {
        this.getHibernateTemplate().save(t);
    }

    /**
     *
     * <p>Description: 保存一批model，功能类似于批量insert</p>
     * @param modelList model对象集合
     * @throws BaseDaoException 数据访问异常
     */
    public void save(List<T> modelList) throws BaseDaoException {
        for (T t : modelList) {
            this.getHibernateTemplate().save(t);
        }
    }

    /**
     *
     * <p>Description: 保存或更新一个model，功能类似于insert或update，根据数据库有无来自动判断</p>
     * @param t model对象
     * @throws BaseDaoException 数据访问异常
     */
    public void saveOrUpdate(T t) throws BaseDaoException {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    /**
     *
     * <p>Description: 保存或更新一批model，功能类似于批量insert或update，根据数据库有无来自动判断</p>
     * @param modelList model对象集合
     * @throws BaseDaoException 数据访问异常
     */
    public void saveOrUpdate(List<T> modelList) throws BaseDaoException {
        this.getHibernateTemplate().saveOrUpdate(modelList);
    }

    /**
     *
     * <p>Description: 更新一个model，功能类似于update</p>
     * @param t model对象
     * @throws BaseDaoException 数据访问异常
     */
    public void update(T t) throws BaseDaoException {
        this.getHibernateTemplate().update(t);
    }

    /**
     *
     * <p>Description: 批量更新一批model，功能类似于批量update</p>
     * @param modelList model对象集合
     * @throws BaseDaoException 数据访问异常
     */
    public void update(List<T> modelList) throws BaseDaoException {
        for (T t : modelList) {
            this.getHibernateTemplate().update(t);
        }
    }

    /**
     *
     * <p>Description: 删除一个model，功能类似于delete</p>
     * @param t model对象
     */
    public void delete(T t) throws BaseDaoException {
        this.getHibernateTemplate().delete(t);
    }

    /**
     *
     * <p>Description: 删除一批model，功能类似于批量delete</p>
     * @param modelList model对象集合
     * @throws BaseDaoException 数据访问异常
     */
    public void delete(List<T> modelList) throws BaseDaoException {
        for (T t : modelList) {
            this.getHibernateTemplate().delete(t);
        }
    }

    /**
     * <p>Description: 根据对象的id来删除对象</p>
     * @param modelClass 对象类
     * @param id 对象id
     * @throws BaseDaoException 数据访问异常
     */
    public void deleteById(Class<T> modelClass, String id) throws BaseDaoException {
        Object o=this.getById(modelClass, id);
        if(o!=null){
            this.getHibernateTemplate().delete(o);
        }
    }


    /**
     *
     * <p>Description: 通过主键查询model对象</p>
     * @param modelClass model类对象
     * @param id 主键
     * @return model对象
     * @throws BaseDaoException 数据访问异常
     */
    public T getById(Class<T> modelClass, String id) throws BaseDaoException {
        return getHibernateTemplate().get(modelClass, id);
    }

    /**
     *
     * <p>Description: 通过SQL执行更新/插入/删除操作，参数需要用:变量名传递进来，如:employeeName</p>
     * @param queryString SQL字符串
     * @param queryMap 参数列表
     * @throws BaseDaoException 数据访问异常
     */
    public void executeSql(String queryString, Map<String, Object> queryMap) throws BaseDaoException {
        SQLQuery query;
        query = this.getSessionFactory().getCurrentSession().createSQLQuery(queryString);
        if (queryMap != null && queryMap.size() > 0 ) {
            for (String queryField : queryMap.keySet()) {
                if(queryMap.get(queryField) != null) {
                    if(queryMap.get(queryField) !=null ) {
                        query.setParameter(queryField, queryMap.get(queryField));
                    }
                }
            }
        }
        query.executeUpdate();
    }

    /**
     *
     * <p>Description: 通过HQL执行更新/插入/删除操作，参数需要用:变量名传递进来，如:employeeName</p>
     * @param queryString HQL字符串
     * @param paramMap 参数列表
     * @throws BaseDaoException 数据访问异常
     */
    public void executeHql(String queryString, Map<String, Object> paramMap) throws BaseDaoException {
        Query query;
        query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
        if (paramMap != null && paramMap.size() > 0 ) {
            for (String queryField : paramMap.keySet()) {
                if(paramMap.get(queryField) != null) {
                    if(paramMap.get(queryField) !=null ) {
                        query.setParameter(queryField, paramMap.get(queryField));
                    }
                }
            }
        }

        query.executeUpdate();
    }

    /**
     *
     * <p>Description: 构造基于SQL的查询，不带查询条件，防止SQL注入问题
     *  对于要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设
     * <pre>
     *      dao.findBySqlQuery(sql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * </p>
     * @param queryString SQL字符串
     * @return model对象列表
     * @throws BaseDaoException 数据访问异常
     */
    public SQLQuery findBySqlQuery(String queryString) throws BaseDaoException {
        SQLQuery query;
        query = this.getSessionFactory().getCurrentSession().createSQLQuery(queryString);
        query.setCacheable(false);
        return query;
    }

    /**
     *
     * <p>Description: 构造一个不带查询条件的HQL查询，防止SQL注入问题
     *  对于要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设
     * <pre>
     *      dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * </p>
     * @param queryString HQL字符串
     * @return model对象列表
     * @throws BaseDaoException 数据访问异常
     */
    public Query findByQuery(String queryString) throws BaseDaoException {
        Query query;
        query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setCacheable(false);
        return query;
    }

}
