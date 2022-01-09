package com.fsk.datapreprocessingtechniques.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstPreprocessing {

    @GetMapping("/")
    public String explain() {
        return """
                <head>
                    <meta charset="UTF-8">
                    <title>Merhaba</title>
                </head>
                <body>
                                
                <strong>İsim:</strong> Furkan Şahin Kulaksız
                <br>
                <strong>Bölüm:</strong> Yazılım Mühendisliği Anabilim Dalı
                <br>
                <strong>Numara:</strong> 208229052002
                <br>
                <strong>Kaynak Kod:</strong><a href="https://github.com/fsk/data-preprocessing-techniques" target="_blank">Kaynak Kod için bu yazının üstüne tıklayınız</a>
                <hr>
                <br>
                <p style="font-size: 32px"><strong><i>Hocam öncelikle ödevi geç göndermeme müsade ettiğiniz için çok teşekkür ederim.</i></strong>
                <strong>Çalıştığım firmada yurtdışı projesi için demo halindeyiz ve sürekli İstanbul - Ankara arası mekik dokumak durumundayım.</strong>
                <strong>İnanın bu ödevin başına da Anca bu haftasonu oturabildim. Cuma günü oturdum. Bu satırları yazarken Pazar saat 21.43</strong>
                <strong>Lisansta bitirme projemde de sizin kurulunuzdaydım. Hatırlarsanız PSO ile sudoku çözdürmüştüm. Normalde gerçekten böyle bir şey yapmazdım
                fakat maalesef bu ödev için böyle oldu. Eksik olan bir kaç nokta var fakat hem yetiştiremeyeceğim sanırım daha fazla. Hem de veri ön işleme tekniklerini
                sizin dersiniz olduğu için aldım. Yoksa sektörde benim çok fazla işime yaramayacak bir ders. Yani dersi geçsem bana yeter. Bu notları yazarken de kendimi
                sınav kağıtlarına not yazan öğrenciler gibi hissettim. ((: Neyse Hocam, sizlere iyi calismalar.</strong></p>
                <br>
                <hr>
                <br>
                <ul>
                    <t>Kullanilan Teknolojiler</t>
                    <li>Java 15</li>
                    <li>Spring Boot</li>
                    <li>Stream API</li>
                    <li>Lambda Expressions - Functional Interfaceler</li>
                    <li>Apache POI</li>
                    <li>Apache Math3 Commons</li>
                    <li>Java String Interpolation</li>
                </ul>
                <p style="font-size: 30px"><strong>Uygulamanin acilmasi icin asagidaki butona tiklayiniz..</strong></p>
                <br>
                <br>
                <button>
                    <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/">UYGULAMA</a>
                </button>
                                
                </body>
                </html>
                """;
    }
}
