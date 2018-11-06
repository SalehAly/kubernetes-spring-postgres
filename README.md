
# Minikube POC

  - Install minikube  https://github.com/kubernetes/minikube/releases
  - open a terminal  
``` sh
$ minikube start 
$ minikube eval $(minikube docker-env) 
$ build demo project with command ``` mvn install docker:build``` `
kubectl apply -f postgres/volume.yaml
kubectl apply -f postgres/postgres.yaml
kubectl apply -f demo/kube-config/spring-boot-demo-config-map.yaml
kubectl apply -f demo/kube-config/spring-boot-demo.yaml
```

- Then you should have two running pods; a service and a db talking to each other.
