package com.devonfw.module.kafka.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

/**
 * class reads producer properties from application.properties as part of POC In actual project Implementation move
 * these to separate location Basic minimum set of properties are considered for POC Current configuration supports
 * plaintext protocol and not SSL
 *
 * @author pravbhav
 *
 */
@PropertySource("classpath:kafka-producer.properties")
public class KafkaProducerProperties {
  /**
   * @return clientId
   */
  public String getClientId() {

	  return this.clientId;
  }

  /**
   * @return bootstrapservers
   */
  public String getBootstrapservers() {

    // kafka.producer.bootstrap.servers
	  return this.bootstrapservers;

  }

  /**
   * @return acks
   */
  public String getAcks() {

	  return this.acks;
  }

  /**
   * @return retries
   */
  public String getRetries() {

	  return this.retries ;

  }

  /**
   * @return batchsize
   */
  public String getBatchsize() {

	return this.batchsize ;

  }

  /**
   * @return lingerms
   */
  public String getLingerms() {

	  return this.lingerms ;

  }

  /**
   * @return buffermemory
   */
  public String getBuffermemory() {

	  return this.buffermemory ;

  }

  /**
   * @return keyserializer
   */
  public String getKeyserializer() {

	  return this.keyserializer ;
  }

  /**
   * @return valueserializer
   */
  public String getValueserializer() {

	  return this.valueserializer ;
  }

  /*
   * Return properties object for producer to be created.
   *
   */

  public void setProperties(Properties prop )
  {

	    setClientId(prop.getProperty("kafka.producer.clientId"));
	    setBootstrapservers(prop.getProperty("kafka.producer.bootstrapservers"));
	  //  prop.setProperty("bootstrap.servers", getBootstrapservers());
	    setAcks(prop.getProperty("kafka.producer.acks") );
	    setRetries(prop.getProperty("kafka.producer.retries"));
	    setBatchsize(prop.getProperty("kafka.producer.batchsize"));
	    setLingerms( prop.getProperty("kafka.producer.lingerms"));
	    setBuffermemory( prop.getProperty("kafka.producer.buffermemory"));
	    setKeyserializer( prop.getProperty("kafka.producer.keyserializer"));
	    setValueserializer( prop.getProperty("kafka.producer.valueserializer"));
  }

  /**
   *
   * @return kafka Producer properties
   */
  public Properties getProperties() {

    Properties prop = new Properties();
    Properties pr = new Properties() ;
    InputStream in = null;
    File file = null ;
    try {
	        file = ResourceUtils.getFile("classpath:kafka-producer.properties");
	        in = new FileInputStream(file);
	        prop.load(in);
	        setProperties(prop);
			in.close();
	} catch (IOException e) {
		 e.printStackTrace();
		 return new Properties();
	}finally {

	}
    pr.setProperty("client.id", getClientId());
    pr.setProperty("bootstrap.servers", getBootstrapservers());
    pr.setProperty("acks", getAcks());
    pr.setProperty("retries", getRetries());
    pr.setProperty("batch.size", getBatchsize());
    pr.setProperty("linger.ms", getLingerms());
    pr.setProperty("buffer.memory", getBuffermemory());
    pr.setProperty("key.serializer", getKeyserializer());
    pr.setProperty("value.serializer", getValueserializer());
    return pr;

  }

  /**
   * @return topic
   */
  public String getTopic() {
	return this.topic ;

  }

  public void setClientId(String clientId) {
	this.clientId = clientId;
}

public void setBootstrapservers(String bootstrapservers) {
	this.bootstrapservers = bootstrapservers;
}

public void setAcks(String acks) {
	this.acks = acks;
}

public void setRetries(String retries) {
	this.retries = retries;
}

public void setBatchsize(String batchsize) {
	this.batchsize = batchsize;
}

public void setLingerms(String lingerms) {
	this.lingerms = lingerms;
}

public void setBuffermemory(String buffermemory) {
	this.buffermemory = buffermemory;
}

public void setKeyserializer(String keyserializer) {
	this.keyserializer = keyserializer;
}

public void setValueserializer(String valueserializer) {
	this.valueserializer = valueserializer;
}

public void setTopic(String topic) {
	this.topic = topic;
}

@Value("${kafka.producer.clientId}")
  private String clientId;

  @Value("${kafka.producer.bootstrapservers}")
  private String bootstrapservers;

  @Value("${kafka.producer.acks}")
  private String acks;

  @Value("${kafka.producer.retries}")
  private String retries;

  @Value("${kafka.producer.batchsize}")
  private String batchsize;

  @Value("${kafka.producer.lingerms}")
  private String lingerms;

  @Value("${kafka.producer.buffermemory}")
  private String buffermemory;

  @Value("${kafka.producer.keyserializer}")
  private String keyserializer;

  @Value("${kafka.producer.valueserializer}")
  private String valueserializer;

  @Value("${kafka.producer.topic}")
  private String topic;

}
