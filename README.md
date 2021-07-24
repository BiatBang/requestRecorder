# requestRecorder
spring boot app demo, recording the request and response

# Goal
在返回用户结果后，记录相关路径的请求以及回复。

#Problem
在HttpServletRequest以及HttpServletResponse中，body保存在inputStream和outStream中。导致每个body只能被读一次。在记录之前，body已经被读过，所以期望将body进行包装，达到可以多次读取的目的。

#Solution
使用Spring提供的ContentCachingRequestWrapper以及ContentCachingResponseWrapper分别包装HttpServletRequest与HttpServletResponse。
使用Spring提供的Interceptor在返回用户结果后（afterCompletion）记录结果。用户不会受到影响。


