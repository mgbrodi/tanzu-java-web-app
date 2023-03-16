SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='083459807443.dkr.ecr.us-east-1.amazonaws.com/0f208c80-bd53-11ed-8112-0e4c20fd0161/tap-supply-chain/hello-app-workload')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='tap-workload')

k8s_custom_deploy(
    'hello-app',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes >/dev/null" +
               " && kubectl get workload hello-app --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('hello-app', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'hello-app'}])
allow_k8s_contexts('arn:aws:eks:us-east-1:083459807443:cluster/cluster-eks-tap')

