import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtility {

    val BASE_URL = "http://192.168.43.229:8080/api/v1/"

    fun apiUtilityFun(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
