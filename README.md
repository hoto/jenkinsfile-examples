# Jenkins Examples


### Update Jenkins plugins

1. Start jenkins container
2. Manually update plugins through the UI
3. Copy output of below command to `plugins.txt` file

    curl -s http://localhost:8080/pluginManager/api/json?depth=1 \
      | jq -r '.plugins[] | "\(.shortName):\(.version)"' \
      | sort
    
4. Rebuild docker image and container to verify the changes
