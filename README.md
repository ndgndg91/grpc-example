# grpc-example

https://github.com/yidongnan/grpc-spring-boot-starter

<h2>install grpcurl</h2>
<pre>
$ brew install grpcurl
</pre>

<h2>list localhost:9090</h2>
<pre>
$ grpcurl --plaintext localhost:9090 list
com.ndgndg91.grpc.stub.product.ProductService
com.ndgndg91.grpc.stub.user.UserService
grpc.health.v1.Health
grpc.reflection.v1alpha.ServerReflection
</pre>

<h2>list ProductService</h2>
<pre>
$ grpcurl --plaintext localhost:9090 list com.ndgndg91.grpc.stub.product.ProductService
com.ndgndg91.grpc.stub.product.ProductService.addProduct
com.ndgndg91.grpc.stub.product.ProductService.getProduct
</pre>

<h2>list UserService</h2>
<pre>
$ grpcurl --plaintext localhost:9090 list com.ndgndg91.grpc.stub.user.UserService
com.ndgndg91.grpc.stub.user.UserService.create
com.ndgndg91.grpc.stub.user.UserService.findById
</pre>

<h2> call create user</h2>
<pre>
$ grpcurl --plaintext -d '{"email": "ndgndg91@gmail.com", "fullName": "Nam Dong Gil" }' localhost:9090 com.ndgndg91.grpc.stub.user.UserService.create
{
  "id": "332b1d8a-574a-4b8f-ab66-1031092ea068"
}
</pre>

<h2> call findById</h2>
<pre>
$ grpcurl --plaintext -d '{"id": "332b1d8a-574a-4b8f-ab66-1031092ea068"}' localhost:9090 com.ndgndg91.grpc.stub.user.UserService.findById
{
  "id": "332b1d8a-574a-4b8f-ab66-1031092ea068",
  "email": "ndgndg91@gmail.com",
  "fullName": "Nam Dong Gil",
  "createdAt": "1651706027"
}

</pre>