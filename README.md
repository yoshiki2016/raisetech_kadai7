# APIの戻り値を確認

バリデーションチェックにかからず正常に処理を終える場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
"petName": "pochi",
"petType": "アメリカンショートヘア",
"petAge" : 2
}' -i
HTTP/1.1 201
Location: http://localhost:8080/pet/id
Content-Type: text/plain;charset=UTF-8
Content-Length: 16
Date: Sat, 27 May 2023 08:52:11 GMT

POST通信成功%  
```

バリデーションチェックにかかり正常に処理を負えられなかった場合
@NotEmptyにnullを入れた場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
"petName": null,
"petType": "アメリカンショートヘア",
"petAge" : 2
}' -i

HTTP/1.1 400
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 27 May 2023 08:52:27 GMT
Connection: close

{"timestamp":"2023-05-27T08:52:27.856+00:00","status":400,"error":"Bad Request","path":"/pet"}%  
```

バリデーションチェックにかかり正常に処理を負えられなかった場合
@NotEmptyにから文字を入れた場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
 "petName": "",
 "petType": "アメリカンショートヘア",
 "petAge" : 2
}' -i

HTTP/1.1 400 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 27 May 2023 08:52:48 GMT
Connection: close

{"timestamp":"2023-05-27T08:52:48.551+00:00","status":400,"error":"Bad Request","path":"/pet"}%        
```

バリデーションチェックにかからず正常に処理を終える場合
@NotEmptyにブランクを入れた場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
 "petName": "   ",
 "petType": "アメリカンショートヘア",
 "petAge" : 2
}' -i

HTTP/1.1 201 
Location: http://localhost:8080/pet/id
Content-Type: text/plain;charset=UTF-8
Content-Length: 16
Date: Sat, 27 May 2023 08:53:10 GMT

POST通信成功%       
```

バリデーションチェックにかかり正常に処理を負えられなかった場合
@NotNullにから文字を入れた場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
 "petName": "pochi",
 "petType": "",
 "petAge" : 2
}' -i

HTTP/1.1 400 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 27 May 2023 08:53:24 GMT
Connection: close

{"timestamp":"2023-05-27T08:53:24.906+00:00","status":400,"error":"Bad Request","path":"/pet"}%
```

バリデーションチェックにかかり正常に処理を負えられなかった場合
＠Sizeの上限値100を超えた文字列を挿入した場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
 "petName": "pochi",
 "petType": "あいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあ いうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあ",
 "petAge" : 2
}' -i

HTTP/1.1 400 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 27 May 2023 08:53:58 GMT
Connection: close

{"timestamp":"2023-05-27T08:53:58.275+00:00","status":400,"error":"Bad Request","path":"/pet"}% 
```

バリデーションチェックにかかり正常に処理を負えられなかった場合
＠Minで指定した値を下回った場合

```
[yoshikishinya@YoshikinoMacBook-Pro] ~
% curl 'http://localhost:8080/pet' -H 'Content-Type: application/json' -d '{
 "petName": "pochi",
 "petType": "アメリカンショートヘア",
 "petAge" : -1
}' -i
HTTP/1.1 400 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 27 May 2023 08:54:20 GMT
Connection: close

{"timestamp":"2023-05-27T08:54:20.413+00:00","status":400,"error":"Bad Request","path":"/pet"}% 
```