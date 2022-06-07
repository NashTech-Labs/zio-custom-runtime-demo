## **ZIO-custom-runtime**

This template demonstrates how to create and use custom runtime in ZIO.

If your application uses custom environment, then it may be useful to create a Runtime specifically tailored for that environment.

A custom Runtime[R] can be created with two values:
<OL>
<li> <B>R Environment:</B> This is the environment that will be provided to effects when they are executed.
<li> <B>Platform:</B> This is a platform that is required by ZIO in order to bootstrap the runtime system.
</OL>

The Main object in this projet is the entry point of the application execution.
In this class, the custom runtime is created using two different ways:
<OL>
<li>
The first one is created using `Runtime` constructor.
The runtime constructor takes two arguments-
<UL>
<li>**Environment**- created by mapping the type of services and their implementations.</li>
<li>**Platform**- selecting the default platform</li>
</UL>
</li>

<li>
The second custom runtime is created using the default runtime. The environment of the default runtime is mapped and combined with the dependencies specific to the application.
</li>
</OL>

### **Useful Commands:**
Run application using: <BR>
`sbt run`