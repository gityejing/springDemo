spring �� jpa ������ʹ��
spring �� springdata ������ʹ��


�漰����jar
<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>2.1.1.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>${hibernate.version}</version>
</dependency>


ע�⣺
@EnableJpaRepositories(basePackages = {"annotation9.dao"}, 
	transactionManagerRef = "transactionManager", 
	entityManagerFactoryRef = "entityManagerFactory")
	
// �ȼ��ڼ̳� JpaRepository<Persion,Long> �ӿ�
@RepositoryDefinition(domainClass=Persion.class,idClass=Long.class)
@Query��@Param�����ʹ�ã����в�ѯ������ӳ��
@Query��@Modifying�����ʹ�ã����Դﵽ�޸ĵ�Ч��
