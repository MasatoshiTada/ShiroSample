ShiroSample
===========

Apache Shiro 1.3 JDBC Realm sample.

Original : Norito AGETSUMA (@n_agetsu)

Upgrade to 1.3 + Thymeleaf : Masatoshi Tada (@suke_masa)

![screenshot](site/screen.png)

environment
-------------
* Payara Web ML 4.1.1.163 (Java EE7)
* Jersey MVC
* Apache Shiro 1.3

setup
--------
1. setting your datasource

    Default datasource jndiname is java:comp/DefaultDataSource (glassfish default. connect for derby)

    * src/main/resources/META-INF/persistence.xml

    ```
    <persistence-unit name="DerbyPU" transaction-type="JTA">
        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <jta-data-source>java:comp/DefaultDataSource</jta-data-source> <= Change your DataSource jndi name
    ```

    * src/main/resources/shiro.ini

    ```
    ds.resourceName = java:comp/DefaultDataSource <= Change your DataSource jndi name
    ```

2. build
    ```
    mvn package
    ```

3. deploy
    ```
    cd glassfish4/bin
    ./asadmin start-database (if user default datasource)
    ./asadmin start-domain
    ./asadmin deploy ShoroSample.war
    ```

4. access

    [http://localhost:8080/ShiroSample](http://localhost:8080/ShiroSample)
