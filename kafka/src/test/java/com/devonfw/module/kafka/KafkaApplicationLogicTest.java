package com.devonfw.module.kafka;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.core.env.Environment;

import com.devonfw.module.kafka.common.KafkaException;
import com.devonfw.module.kafka.config.KafkaConsumerProperties;
import com.devonfw.module.kafka.config.KafkaProducerProperties;
import com.devonfw.module.kafka.consumer.KafkaMessageConsumer;
import com.devonfw.module.kafka.logic.KafkaConsumerLogic;
import com.devonfw.module.kafka.logic.KafkaProducerLogic;
import com.devonfw.module.kafka.message.KafkaMessage;
import com.devonfw.module.kafka.producer.KafkaMessageProducer;
import com.devonfw.module.kafka.producer.KafkaRecordMetaData;

import mockit.MockUp;
import mockit.integration.junit4.JMockit;

/**
 * @author dichowdh
 *
 */
@RunWith(JMockit.class)
public class KafkaApplicationLogicTest {

  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  RecordMetadata metadata ;

  @Mock
  KafkaProducer<String, String> strProducer;

  @InjectMocks
  KafkaProducerLogic kafkaProducerLogic;


  @Mock
  KafkaMessageProducer producer;

  @Mock
  static KafkaProducerProperties kafkaProducerProperties;



  private List<ConsumerRecord<byte[], byte[]>> recordMetadata;

  @Mock
  KafkaMessageConsumer consumer;


  @Mock
  static KafkaConsumerProperties kafkaConsumerProperties;



  @Mock
  KafkaConsumer<String, String> strConsumer;

  @InjectMocks
  KafkaConsumerLogic kafkaConsumerLogic;

  /**
   *
   */
  public void mockKafkaConsumer() {

    new MockUp<KafkaConsumer>() {
      @mockit.Mock
      public void $init() {

      }
    };
  }

  /**
  *
  */
 public void mockKafkaProducer() {

   new MockUp<KafkaProducer>() {
     @mockit.Mock
     public void $init() {

     }
   };
 }

  /**
   *
   */
  @Before
  public void setUp() {

    MockitoAnnotations.initMocks(this);

    kafkaConsumerProperties = new KafkaConsumerProperties();
    Properties prop = kafkaConsumerProperties.getProperties();
    kafkaConsumerProperties.setProperties(prop);


    kafkaProducerProperties = new KafkaProducerProperties();
    Properties properties = kafkaProducerProperties.getProperties();
    kafkaProducerProperties.setProperties(properties);


   }

  /**
  *
  */
  @Test
 public void sendMessageTest() {

   String value = "ABC";
   Mockito.when(this.producer.sendTextMessage(Mockito.anyString(), Mockito.anyString()))
       .thenReturn(this.metadata);
   KafkaRecordMetaData result = this.kafkaProducerLogic.sendMessage("test", value);

 }

 /**
  *
  */
 @Test
 public void sendMessageTest1() {

   String value = "ABC";
   String key = "1001" ;
   Mockito.when(this.producer.sendTextMessage(Mockito.anyString(), Mockito.anyString()))
       .thenReturn(this.metadata);

   KafkaRecordMetaData result = this.kafkaProducerLogic.sendMessage("test", key, value);
 }



  /**
   *
   */

  @Test
  public void receiveMessageTest() {

    Mockito.when(this.consumer.consumeTextMesage(Mockito.anyString())).thenReturn(this.recordMetadata);
    try {
      List<KafkaMessage> result = this.kafkaConsumerLogic.consumeTextMessage("test");
      System.out.println("Result" +  result) ;

    } catch (KafkaException e) {

      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }



}
