# Jenkins Examples

Library of working Jenkinsfiles which can be fiddled with in your favourite text editor and run in Jenkins..

### Why

Jenkins documentations lacks in examples of Jenkinsfile pipeline features.
I needed working examples of various Jenkinsfiles which I could modify in my text editor and run them in Jenkins after saving the file.

### How it works

[jenkinsfile-loader](https://github.com/hoto/jenkinsfile-loader) uses Jenkins REST API to create Jenkins jobs directly from Jenkinsfiles located in `jenkinsfiles` directory.
It also monitors any change in that folder and will update, create or remove jobs accordingly.  
All files must be named `<job_name>.groovy` where `<job_name>` will be used for the Jenkins job name.
There is no auto-refresh, so after adding or removing files Jenkins page needs to be refreshed manually to reflect changes.

### Run

This will pull and start latest docker images

    docker-compose pull
    docker-compose up
    
Wait for Jenkins to boot up. Authentication is disabled. Open a browser and go to:

    localhost:8080
    
If you don't see any jobs refresh the browser and check the `docker-compose` logs.

To stop press `CTRL+C` in terminal.  

To remove all containers with all of its data run:

    docker-compoes down

### Install and update Jenkins plugins

If you just want to test plugins without committing them to git then stop at step 2.

1. Start jenkins container.
2. Manually install or update plugins through the UI.
3. Restart jenkins to verify it's still working.
4. Copy output of the following command to `plugins.txt` file (located in this repository):

        curl -s http://localhost:8080/pluginManager/api/json?depth=1 \
          | jq -r '.plugins[] | "\(.shortName):\(.version)"' \
          | sort
    
5. Rebuild docker image and start new containers to verify new plugins have been installed:

        docker-compose build
        docker-compose down
        docker-compose up

### Components:
  - [jenkins](https://hub.docker.com/_/jenkins/)
  - [jenkinsfile-loader](https://github.com/hoto/jenkinsfile-loader) - Uses Jenkins API and creates jobs directly from Jenkinsfiles.
  
