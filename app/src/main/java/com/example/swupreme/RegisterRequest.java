package com.example.swupreme;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//회원가입 서버 연결
public class RegisterRequest extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://dlwndms0812.dothome.co.kr/Register2.php";
    private Map<String,String>map;

    public RegisterRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);//위 url에 post방식으로 값을 전송

        map=new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
    //throw 처리 하고 알아서 함수 작성해야 겠는걸 아님 변환 사이트 쓰거나 ㄴ
}

