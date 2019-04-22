package com.devonfw.module.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devonfw.module.kafka.common.KafkaException;
import com.devonfw.module.kafka.message.KafkaMessage;
import com.devonfw.module.kafka.message.Message;
import com.devonfw.module.kafka.producer.KafkaRecordMetaData;

/**
 * @author pravbhav
 *
 */

@RestController

public interface KafkaProducerService {

  public static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

  /**
   *
   * @param topic
   * @param msg
   * @return
   */

  @RequestMapping(value = "/kafka/{topic}/message", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)
  public KafkaRecordMetaData sendMessage(@PathVariable String topic, @RequestBody Message msg);

  /**
   * @param topic
   * @param key
   * @param msg
   * @return
   * @throws KafkaException
   */

  @RequestMapping(value = "/kafka/{topic}/{key}", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)
  KafkaRecordMetaData sendMessage(@PathVariable String topic, @PathVariable String key, @RequestBody Message msg)
      throws KafkaException;

  /**
   * @param msg
   * @return
   * @throws KafkaException
   */

  @RequestMapping(value = "/kafka/message", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)
  KafkaRecordMetaData sendMessage(@RequestBody Message msg) throws KafkaException;

  /**
   *
   * @param msg
   * @throws KafkaException
   */

  @RequestMapping(value = "/kafka/asyncmessage", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)
  public void sendAyncMessage(@RequestBody KafkaMessage msg) throws KafkaException;

  /**
   *
   * @param msg
   * @return
   * @throws KafkaException
   */

  @RequestMapping(value = "/kafka/kafkamessage", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)
  public KafkaRecordMetaData sendMessage(@RequestBody KafkaMessage msg) throws KafkaException;

  /**
   *
   * @param topic
   * @param partition
   * @param key
   * @param msg
   * @return
   * @throws KafkaException
   */

  @RequestMapping(value = "/kafka/{topic}/{partition}/{key}", produces = { "application/json" }, consumes = {
  "application/json" }, method = RequestMethod.POST)

  public KafkaRecordMetaData sendMessage(@PathVariable String topic, @PathVariable String partition,
      @PathVariable String key, @RequestBody String msg) throws KafkaException;

  /**
   *
   * @param topic
   * @param partition
   * @param timestamp
   * @param key
   * @param msg
   * @return
   * @throws KafkaException
   */
  @RequestMapping(value = "/kafka/{topic}/{partition}/{timestamp}/{key}", produces = {
  "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)

  public KafkaRecordMetaData sendMessage(@PathVariable String topic, @PathVariable String partition,
      @PathVariable String timestamp, @PathVariable String key, @RequestBody String msg) throws KafkaException;

}
