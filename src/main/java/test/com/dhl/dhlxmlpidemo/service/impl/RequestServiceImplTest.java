package test.com.dhl.dhlxmlpidemo.service.impl;

import com.dhl.dhlxmlpidemo.service.impl.RequestServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * RequestServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2019</pre>
 */
public class RequestServiceImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getShippment()
     */
    @Test
    public void testGetShippment() throws Exception {
        RequestServiceImpl requestService = new RequestServiceImpl();
        requestService.getShippment();
    }


} 
