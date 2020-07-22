package com.sample.sleepycat;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.io.File;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;


@ApplicationScoped
@Path("/test")
public class Test {

	
	@GET
	@Produces(TEXT_PLAIN)
	@Path("/sleepy")
	public String testSleepy() throws Exception {
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
	   	   
		
		return String.format("success");
	}
}
