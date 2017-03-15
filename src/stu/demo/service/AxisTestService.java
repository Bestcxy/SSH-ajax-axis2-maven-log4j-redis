

/**
 * AxisTestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */

    package stu.demo.service;

    /*
     *  AxisTestService java interface
     */

    public interface AxisTestService {
          

        /**
          * Auto generated method signature
          * 
                    * @param writeStr0
                
         */

         
                     public stu.demo.service.WriteStrResponse writeStr(

                        stu.demo.service.WriteStr writeStr0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param writeStr0
            
          */
        public void startwriteStr(

            stu.demo.service.WriteStr writeStr0,

            final stu.demo.service.AxisTestServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    