package com.est.one_to_many.mapping1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration config = new Configuration();
        config.configure("Saurabh1.xml");
        SessionFactory factory = config.buildSessionFactory();
        
        Question q1 = new Question();
        q1.setQuestion("python");
        q1.setQuestionId(285);
         
        
        Answer a1 = new Answer();
        a1.setAnswer("language");
        a1.setAnswerId(256);
        a1.setQuestion(q1);
        
        
        Answer a2 = new Answer();
        a2.setAnswer("its a IDE");
        a2.setAnswerId(987);
        a2.setQuestion(q1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(a1);
        list.add(a2);
        q1.setAnswer(list);
        
        Session s1=factory.openSession();
        Transaction tx=s1.beginTransaction();
         
        s1.save(q1);
        s1.save(a1);
        s1.save(a2);
        
        tx.commit();
        s1.close();
        factory.close();
    }
}
