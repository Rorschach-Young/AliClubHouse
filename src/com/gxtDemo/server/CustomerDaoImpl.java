package com.gxtDemo.server;

import com.gxtDemo.server.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository("customerDao")
@SuppressWarnings("all")
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public Customer save(Customer customer) {
        Serializable result = this.getCurrentSession().save(customer);
        customer.setId((Integer)result);
        return customer;
    }

    @Override
    public void deleteByPrimarykey(List<Integer> ids) {
        String sql = "delete from customer where id in (";
        for (Integer id : ids){
            sql += id + ",";
        }
        sql = sql.substring(0, sql.length() -1) + ")";
        this.getCurrentSession().createSQLQuery(sql).executeUpdate();
    }

    @Override
    public void updateByPrimaryKey(Customer customer) {
        this.getCurrentSession().update(customer);
    }


    @Override
    public List<Customer> listByCustomerOr(Customer customer) {
        // 条件查询
        Disjunction disjunction = Restrictions.disjunction();
        if (customer.getCode() != null && !customer.getCode().isEmpty()){
            Criterion code = Restrictions.eq("code",customer.getCode());
            disjunction.add(code);
        }
        if (customer.getName() != null && !customer.getName().isEmpty()){
            Criterion name = Restrictions.eq("name",customer.getName());
            disjunction.add(name);
        }
        if (customer.getMnemonicCode() != null && !customer.getMnemonicCode().isEmpty()){
            Criterion mnemonicCode = Restrictions.eq("mnemonicCode",customer.getMnemonicCode());
            disjunction.add(mnemonicCode);
        }
        return this.getCurrentSession().createCriteria(Customer.class).add(disjunction).list();
    }
}

