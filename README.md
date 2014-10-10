Run with weld
```
mvn clean install -P weld
```


Run with jboss (BROKEN)
```
mvn clean install -P jbossas
```
Clean up jboss, kill mvn process then:
```
pkill -9 -f jboss
```
