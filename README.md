# scrappermonitor
Scrapper monitor


This system is made up of logstash, spring boot and rabbitmq.<br>

The sequency of operation<br>
0. The scrapper monitor received status data of the crawler from rabbitmq.<br>
1. The scrapper monitor update the status table of the crawler.<br>
2. The quartz schedueler check whether the crawler is valid or not.<br>
3. If the crawler is invalid, send alarm e-mail to admin.<br>

The future lists<br>
0. The visualized reporting.<br>
1. The pattern finder using machine learning.<br>
