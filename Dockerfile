FROM docker.io/jenkins/jenkins:2.141

COPY source/jenkins/usr/share/jenkins/plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

COPY source/jenkins/ /
