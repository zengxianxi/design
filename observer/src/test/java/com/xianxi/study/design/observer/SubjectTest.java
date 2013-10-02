package com.xianxi.study.design.observer;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zengxianxi
 * @since 13-9-22 下午2:06
 */
public class SubjectTest {

    private Subject subject;
    @Before
    public void initSubject(){
       subject = new ConcreteSubject();
    }

    @Test
    public void testObserver(){
        MyObserver obj1 = new ConcreteObserver();

        subject.attach(obj1);

        final int[] sum = new int[1];
        MyObserver obj2 = new MyObserver() {
            @Override
            public void update(MyEvent event) {
               sum[0]++;
            }
        };

        MyObserver obj3 = new MyObserver() {
            @Override
            public void update(MyEvent event) {
                sum[0]++;
            }
        };

        subject.attach(obj2);
        subject.attach(obj3);
        subject.inform();

        Assert.assertEquals(2,sum[0]);
        subject.detach(obj2);

        subject.inform();

        Assert.assertEquals(3,sum[0]);

        subject.detach(obj2);
        subject.detach(obj3);

    }

}
