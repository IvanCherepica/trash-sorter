//package com.example;
//
//import com.dynamsoft.barcode.BarcodeReader;
//import com.dynamsoft.barcode.PublicRuntimeSettings;
//import com.dynamsoft.barcode.TextResult;
//import com.google.gson.Gson;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//@MultipartConfig(fileSizeThreshold = 1024 * 1024,
//        maxFileSize = 1024 * 1024 * 5,
//        maxRequestSize = 1024 * 1024 * 5 * 5)
//public class MultipartServlet extends HttpServlet {
//
//    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter responseWriter = response.getWriter();
//
//
//
//        Part imgPart = request.getPart("img");
//
//        try {
//            // if licenseKeys expire, visit https://www.dynamsoft.com/CustomerPortal/Portal/TrialLicense.aspx to get a try key
//            BarcodeReader reader = new BarcodeReader("t0124lQMAAER5WDsMuFPKwNHna6Nzdn1k9kTi90HC1XQVHi88GaujMe96F4Twr+owSAEUoQF3KZU0FCctBHrc6iGdgyC1FaSVtxJpmNMwp2FOw5yGmYaZhpmGmYaZhlmGWYZZhlmGub51/0RtNhrVTaBqOKt/cxydir1fF2yxgA==");
//
//            // how to choose settings? visit https://demo.dynamsoft.com/dbr_h5/ => settings
//            PublicRuntimeSettings settings = reader.getRuntimeSettings();
//            settings.expectedBarcodesCount = 512;
//            settings.scaleDownThreshold = 4096;
//            reader.updateRuntimeSettings(settings);
//            // want to reset settings? using:
//            //reader.resetRuntimeSettings();
//
//            TextResult[] results = reader.decodeFileInMemory(imgPart.getInputStream(), "");
//
//            responseWriter.write(new Gson().toJson(results));
//
//
//        } catch (Exception e) {
//            responseWriter.write(new Gson().toJson(e));
//        }finally{
//            responseWriter.close();
//        }
//    }
//}
