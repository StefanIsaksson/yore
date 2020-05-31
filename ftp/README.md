# FTP Server running inside Docker Container

## How?

### How to connect?
	Connect with FTP client to:
	host: localhost
	port: 21
	username: user
	password: password

### Where are the uploaded files?
Files uploaded to this ftp (with username: `user`) will be accesible under directory `./user`
	
### How to configure docker container
See the servie `ftp` in the file `../docker-compose.yml` 

## Why?
I want a FTP Server running locally to practice reading from such a source with Apache Camel. 
The Camel code is not written yet.

## What?
https://hub.docker.com/r/fauria/vsftpd/