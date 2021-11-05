# OrderControllerApi

All URIs are relative to *http://localhost:9090*

Method | HTTP request | Description
------------- | ------------- | -------------
[**all**](OrderControllerApi.md#all) | **GET** /orders | 
[**create**](OrderControllerApi.md#create) | **POST** /orders | 
[**one**](OrderControllerApi.md#one) | **GET** /orders/{id} | 
[**test**](OrderControllerApi.md#test) | **POST** /orders/{path1}/{path2} | 
[**update**](OrderControllerApi.md#update) | **PUT** /orders/{id} | 


<a name="all"></a>
# **all**
> kotlin.collections.List&lt;Order&gt; all()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.github.anddd7.client.dto.*

val apiInstance = OrderControllerApi()
try {
    val result : kotlin.collections.List<Order> = apiInstance.all()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrderControllerApi#all")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrderControllerApi#all")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;Order&gt;**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="create"></a>
# **create**
> kotlin.String create(createOrderCommand)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.github.anddd7.client.dto.*

val apiInstance = OrderControllerApi()
val createOrderCommand : CreateOrderCommand =  // CreateOrderCommand | 
try {
    val result : kotlin.String = apiInstance.create(createOrderCommand)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrderControllerApi#create")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrderControllerApi#create")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createOrderCommand** | [**CreateOrderCommand**](CreateOrderCommand.md)|  |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="one"></a>
# **one**
> Order one(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.github.anddd7.client.dto.*

val apiInstance = OrderControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : Order = apiInstance.one(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling OrderControllerApi#one")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrderControllerApi#one")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="test"></a>
# **test**
> test(path1, path2, query2, order, query1)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.github.anddd7.client.dto.*

val apiInstance = OrderControllerApi()
val path1 : kotlin.String = path1_example // kotlin.String | 
val path2 : kotlin.String = path2_example // kotlin.String | 
val query2 : kotlin.String = query2_example // kotlin.String | 
val order : Order =  // Order | 
val query1 : kotlin.String = query1_example // kotlin.String | 
try {
    apiInstance.test(path1, path2, query2, order, query1)
} catch (e: ClientException) {
    println("4xx response calling OrderControllerApi#test")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrderControllerApi#test")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **path1** | **kotlin.String**|  |
 **path2** | **kotlin.String**|  |
 **query2** | **kotlin.String**|  |
 **order** | [**Order**](Order.md)|  |
 **query1** | **kotlin.String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="update"></a>
# **update**
> update(id, order)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.github.anddd7.client.dto.*

val apiInstance = OrderControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val order : Order =  // Order | 
try {
    apiInstance.update(id, order)
} catch (e: ClientException) {
    println("4xx response calling OrderControllerApi#update")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling OrderControllerApi#update")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **order** | [**Order**](Order.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

