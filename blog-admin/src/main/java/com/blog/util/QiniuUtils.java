package com.blog.util;

import com.alibaba.fastjson.JSON;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Slf4j
public class QiniuUtils {
    public static  final String url = "https://rvrbvhws8.hd-bkt.clouddn.com/";


    private  String accessKey  = VariableName.accessKey;

    private  String accessSecretKey = VariableName.secretKey;

    //要上传的空间
    private static String bucketname = VariableName.bucket; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）


    //密钥配置


    public  boolean upload(MultipartFile file, String fileName){
        log.info("upload方法触发");
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huadong());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String bucket = VariableName.bucket;
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            byte[] uploadBytes = file.getBytes();
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(uploadBytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void deleteAll() throws QiniuException {
        String bucket = "wwwmszlucom";
        Auth auth = Auth.create(accessKey, accessSecretKey);
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huabei());
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing fileListing = bucketManager.listFiles(bucket, "/", "", 1000, "");
        FileInfo[] items = fileListing.items;
        for (FileInfo info : items){

        }
    }

}
