# Jenkins Examples


### Install and update Jenkins plugins

1. Start jenkins container.
2. Manually install or update plugins through the UI.
3. Restart jenkins to verify it's still working.
4. Copy output of following command to `plugins.txt` file:

    curl -s http://localhost:8080/pluginManager/api/json?depth=1 \
      | jq -r '.plugins[] | "\(.shortName):\(.version)"' \
      | sort
    
5. Rebuild docker image and container to verify the changes.
