INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('636db93f-e790-42b0-9d9a-545243645291','customer-service','customer-service','label1','spring.application.name','customer-service'),
	 ('2c7c0ef4-ec9e-46d4-826e-f5cc6083c7bc','customer-service','customer-service','label1','eureka.instance.instanceId','myhost:customer-service:8081'),
	 ('abdcd1f6-5fe8-4296-9cc7-3bb8226244de','customer-service','customer-service','label1','server.port','8081'),
	 ('4f786751-ced7-4a18-8018-002a6354580c','order-service','order-service','label1','spring.liquibase.change-log','classpath:/migration/master-changelog.xml'),
	 ('4ea9caa3-a8be-47c0-844f-8e8e872dd9f2','gateway','gateway','label1','application.authentication.access_token.jwt_secretZ','8GJ64eimY'),
	 ('5707788e-8afb-4d3f-8cf8-6830bacabfeb','gateway','gateway','label1','application.authentication.access_token.life_time','3600000'),
	 ('b2cd72af-b978-41bb-99d8-d1813d03087a','gateway','gateway','label1','application.authentication.refresh_token.life_time','3600000'),
	 ('a4f19771-64f5-41db-987c-144fad5b3d5c','gateway','gateway','label1','application.authentication.refresh_token.jwt_secret','Z8GJ64eimY'),
	 ('b286c60d-0b40-4729-a47d-5e3074a2543d','gateway','gateway','label1','eureka.client.service-url.defaultZone','${EUREKA_URI:http://localhost:8761/eureka}'),
	 ('12cd017d-818f-437f-9490-4363f7f3a9b1','gateway','gateway','label1','eureka.instance','instanceId:myhost:myappname:9091');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('e4390847-20cf-4f8f-a0f6-b0a1ab008114','gateway','gateway','label1','spring.application.name','gateway-service'),
	 ('41e59056-4c1b-4923-8fc0-662e9b71ab40','gateway','gateway','label1','spring.cloud.gateway.routes.id','verify-application'),
	 ('4694b2c1-b367-41b2-8a56-b648ce7e5c13','gateway','gateway','label1','spring.cloud.gateway.routes.uri','lb://user-service:8088'),
	 ('873ae744-8017-48df-b281-251629d9d0b1','gateway','gateway','label1','spring.cloud.gateway.routes.predicates','Path=/api/v1/users'),
	 ('bfc967f3-b3ac-4ffb-92bf-7bc47e8cec00','gateway','gateway','label1','spring.zipkin.base-url','http://localhost:9411/'),
	 ('9b4f78eb-dc95-4364-b6d3-35ec6efdc440','gateway','gateway','label1','spring.zipkin.sleuth','probability=1.0'),
	 ('f8af5bd3-912a-447f-a6bb-6db8953e4719','gateway','gateway','label1','spring.datasource.url','jdbc:postgresql://localhost:5432/authen'),
	 ('3d8b8d02-7372-49e3-b82e-6b08c3285422','gateway','gateway','label1','spring.datasource.username','postgres'),
	 ('c1950277-be82-417c-9357-862c2e46986e','gateway','gateway','label1','spring.datasource.password','linh2002'),
	 ('71067817-19b4-43b2-8edd-14b9f0786487','gateway','gateway','label1','spring.jpa.hibernate.ddl-auto','update');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('829401bf-a774-4117-a978-32d4fcdd8b6f','gateway','gateway','label1','spring.jpa.show-sql','true'),
	 ('61631cf1-b54d-4684-a3db-c6dc95f40b7e','gateway','gateway','label1','spring.cache.type','redis'),
	 ('cdd80db5-96cf-43d1-b874-f619251eec05','gateway','gateway','label1','spring.redis.port','6379'),
	 ('145ac3f0-9de9-41c9-9000-83a73f83489f','gateway','gateway','label1','spring.redis.host','localhost'),
	 ('2a804c5f-0cd5-4d0d-a8e7-25a67c2422b3','gateway','gateway','label1','spring.main.web-application-type','reactive'),
	 ('2926853d-fc97-43f0-8c7d-f984c0f4e5b3','gateway','gateway','label1','spring.main.allow-bean-definition-overriding','true'),
	 ('72626b54-1fbf-47aa-9027-19ffaeb7555c','gateway','gateway','label1','spring.mvc.pathmatch.matching-strategy','ant_path_matcher'),
	 ('ae846798-ab29-4817-b62b-24cdaa589d14','order-service','order-service','label1','spring.datasource.username','postgres'),
	 ('17d6f2e4-7c1a-4f91-9808-8e71ddf44bad','gateway','gateway','label1','server.port','9091'),
	 ('cdc1ac15-7ca5-4806-b33d-ed9c3e8dd43e','eureka-server','eureka-server','label1','server.port','8761');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('88bb98b3-2348-448d-b24f-77ca159d3e1e','eureka-server','eureka-server','label1','spring.application.name','eureka-server'),
	 ('4a68dcec-5ebc-46b6-90e2-aea6ac9ebf8e','eureka-server','eureka-server','label1','eureka.instance.hostname','eureka-server'),
	 ('44c99742-ae59-44f1-8e8d-318af8123260','eureka-server','eureka-server','label1','eureka.client.register-with-eureka','false'),
	 ('a143eed5-1bef-450b-83a2-3d049d4ba25f','eureka-server','eureka-server','label1','eureka.client.fetch-registry','false'),
	 ('b8f2349e-267b-4b29-b2a8-691a7dc3d4d6','order-service','order-service','label1','spring.liquibase.change-log','classpath:/migration/master-changelog.xml'),
	 ('a22d8944-0bbc-4dfa-844b-9a2bf8620a83','order-service','order-service','label1','spring.datasource.url','jdbc:postgresql://localhost:5432/order'),
	 ('feca28b2-6e79-4116-b009-db9a98086f90','order-service','order-service','label1','spring.datasource.username','postgres'),
	 ('f8e828fa-25f4-4422-9c52-75d62a7dacd0','order-service','order-service','label1','spring.datasource.password','linh2002'),
	 ('67bdbcab-06d5-4bf7-b7c9-b8ac02d9d857','order-service','order-service','label1','spring.application.name','order-service'),
	 ('71814bd5-027f-4550-821e-558b0a79870d','order-service','order-service','label1','eureka.client.serviceUrl.defaultZone','http://localhost:8761/eureka');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('1b7e97f9-9c88-4d53-b94f-990a33a37b04','order-service','order-service','label1','eureka.instance.instanceId','myhost:order-service:8080'),
	 ('e544c95c-4f19-40dd-85c3-ed8fa3079bd4','customer-service','customer-service','label1','spring.liquibase.change-log','classpath:/migration/master-changelog.xml'),
	 ('775611a9-2e8c-42b6-876e-d7c0937443d4','customer-service','customer-service','label1','spring.datasource.url','jdbc:postgresql://localhost:5432/customer'),
	 ('820f30c9-c79a-48ed-8f73-bb93ebde9bf8','customer-service','customer-service','label1','spring.datasource.username','postgres'),
	 ('392021a7-48c9-40ae-983d-b538f492a733','customer-service','customer-service','label1','spring.datasource.password','linh2002'),
	 ('b2cdfada-d4ef-40bf-a336-90ca505cdd59','customer-service','customer-service','label1','eureka.client.serviceUrl.defaultZone','http://localhost:8761/eureka'),
	 ('dc554ec5-3b44-4eb5-97e4-aff2eb30e6a5','order-service','order-service','label1','spring.datasource.password','linh2002'),
	 ('2e5a07b2-98da-4a35-ad5f-b0b6e1f00c45','order-service','order-service','label1','spring.jpa.hibernate.ddl-auto','none'),
	 ('56e07f79-16c2-456e-a90d-791776eb81f9','order-service','order-service','label1','spring.jpa.show-sql','true'),
	 ('e8821364-ef88-4814-9a91-139974b7be88','order-service','order-service','label1','spring.application.name','order-service');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('1fef0eb7-a080-4590-b453-2ccc7300c46a','order-service','order-service','label1','eureka.client.serviceUrl.defaultZone','http://localhost:8761/eureka'),
	 ('3af23120-aa22-4d08-9aa1-6ffbd823c3fb','order-service','order-service','label1','eureka.instance.instanceId','myhost:order-service:8080'),
	 ('cd0117ba-9182-4748-af1a-547da9c6bc46','customer-service','customer-service','label1','spring.liquibase.change-log','classpath:/migration/master-changelog.xml'),
	 ('b596665e-80b0-428b-a22b-f76bfa0db086','customer-service','customer-service','label1','spring.datasource.url','jdbc:postgresql://localhost:5432/customer'),
	 ('1557c369-df5a-44e0-9c05-7d01f0d515ac','customer-service','customer-service','label1','spring.datasource.username','postgres'),
	 ('fc61baf9-73e0-421e-b337-afa55a44d17f','customer-service','customer-service','label1','spring.datasource.password','linh2002'),
	 ('a48f3e0f-8725-41d2-82ac-d741b8ff42c8','customer-service','customer-service','label1','spring.application.name','customer-service'),
	 ('0d89d159-65d2-4574-b36b-0b4dba4974e2','customer-service','customer-service','label1','server.port','8080'),
	 ('c9916579-2164-42f7-9634-3effdc088760','customer-service','customer-service','label1','application.i18n.resources','classpath:customer-service/message'),
	 ('1dc6a254-1016-423a-91a4-936e49251091','customer-service','customer-service','label1','eureka.client.serviceUrl.defaultZone','http://localhost:8761/eureka');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('da07133b-a7ff-4a77-b089-6677c7edd927','customer-service','customer-service','label1','eureka.instance.instanceId','myhost:customer-service:8080'),
	 ('2','orchestrator-service','orchestrator-service','label1','kafka.topics.process-payment','process_payment'),
	 ('3','orchestrator-service','orchestrator-service','label1','kafka.topics.order-pay-success','update_status_order_pay_success'),
	 ('5','orchestrator-service','orchestrator-service','label1','kafka.topics.listener','payment_success'),
	 ('03e32499-0bcc-4f23-835d-cd2f1f21d8a4','order-service','order-service','label1','spring.datasource.url','jdbc:postgresql://localhost:5432/order'),
	 ('8','order-service','order-service','label1','kafka.topic.name.product_delivery_success','product_delivery_success'),
	 ('9','order-service','order-service','label1','kafka.group.name.order_service','order_service'),
	 ('10','order-service','order-service','label1','kafka.topics.update_status_order_pay_success','update_status_order_pay_success'),
	 ('11','order-service','order-service','label1','spring.kafka.bootstrap-servers','localhost:9092'),
	 ('13','orchestrator-service','orchestrator-service','label1','kafka.topics.order-pay-failed','refund ');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('27',NULL,NULL,'label1',NULL,NULL),
	 ('28',NULL,NULL,'label1',NULL,NULL),
	 ('29',NULL,NULL,'label1',NULL,NULL),
	 ('6','orchestrator-service','orchestrator-service','label1','kafka.group','orchestrator_service'),
	 ('16','order-service','order-service','label1','kafka.group','order_service'),
	 ('25','orchestrator-service','orchestrator-service','label1','eureka.instance.instanceId','myhost:orchestrator-service:8081'),
	 ('7','order-service','order-service','label1','kafka.topic.name.product_delivery_failed','product_delivery_failed'),
	 ('4','orchestrator-service','orchestrator-service','label1','kafka.topics.inventory-check','product_delivery_failed'),
	 ('20','orchestrator-service','orchestrator-service','label1','kafka.group','orchestrator_service'),
	 ('21','orchestrator-service','orchestrator-service','label1','application.i18n.resources','classpath:orchestrator-service/message');
INSERT INTO public.data_cloud (id,application,profile_client,"label",prop_key,value_config) VALUES
	 ('22','orchestrator-service','orchestrator-service','label1','kafka.bootstrap-servers','localhost:9092'),
	 ('14','orchestrator-service','orchestrator-service','label1','kafka.topics.product-delivery','inventory_check'),
	 ('26','item','item','label1','spring.datasource.password','linh2002'),
	 ('23','orchestrator-service','orchestrator-service','label1','kafka.topics.product_delivery_failed','process_product_delivery_failed'),
	 ('24','orchestrator-service','orchestrator-service','label1','eureka.client.serviceUrl.defaultZone','http://localhost:8761/eureka');
