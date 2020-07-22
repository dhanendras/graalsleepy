package com.sample.sleepycat;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EnvironmentConfig envConfig = new EnvironmentConfig();
   	 DatabaseConfig myDbConfig = new DatabaseConfig();
   	 envConfig.setAllowCreate(true);
   	
   	 myDbConfig.setAllowCreate(true);
   	 File envFile=new File("dbEnv");
   	 if(!envFile.exists())
   		 envFile.mkdir();
   	 Environment myDbEnvironment = new Environment(envFile,envConfig);
   	    StoreConfig storeConfig = new StoreConfig();
   	    storeConfig.setAllowCreate(true);
   	    EntityStore ent = new EntityStore(myDbEnvironment, "nodedata", storeConfig);

   	    Database nodeDB = myDbEnvironment.openDatabase(null,"nodeDB",myDbConfig);
   	   
        
    }
}
