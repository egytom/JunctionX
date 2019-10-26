`minikube start --vm-driver kvm2`

or 

`minikube config set vm-driver kvm2`
`minikube start`

from project root:

`kubectl apply -f kubernetes/mongodb-configmap.yaml`
`kubectl apply -f kubernetes/mongodb-secret.yaml`
`kubectl apply -f kubernetes/mongodb-deployment.yaml`
`kubectl apply -f kubernetes/gateway-deployment.yaml`
`kubectl apply -f kubernetes/atm-finder-deployment.yaml`
`kubectl apply -f kubernetes/ingress.yaml`

http://localhost:8081/swagger-ui.html#/
http://localhost:8081/atm-finder/all-atm/{deposit}

deposit = true/false
