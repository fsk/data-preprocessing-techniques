package com.fsk.datapreprocessingtechniques.controller;

import com.fsk.datapreprocessingtechniques.service.DataPreprocessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data-preprocessor-techniques/")
public class DataPreprocess {

    private final DataPreprocessService dataPreprocessService;

    public DataPreprocess(DataPreprocessService dataPreprocessService) {
        this.dataPreprocessService = dataPreprocessService;
    }

    @GetMapping("/average/{columnName}")
    public double average(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.average(columnName);
    }

    @GetMapping("/mode/{columnName}")
    public Double mode(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.mode(columnName);
    }

    @GetMapping("/standartDeviation/{columnName}")
    public Double standartDeviation(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.standartDeviation(columnName);
    }


    @GetMapping("/iqr/{columnName}")
    public Double iqr(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.IQR(columnName);
    }

    @GetMapping("min-max-normalization/{columnName}")
    public List minMaxNormalization(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.minMaxNormalization(columnName);
    }


    @GetMapping("five-number-summary/{columnName}")
    public Map<String, Double> fiveNumberSummary(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.fiveNumberSummary(columnName);
    }


    @GetMapping("z-score-normalization/{columnName}")
    public List<Double> zScoreNormalization(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.zScoreNormalization(columnName);
    }


    @GetMapping("three-width-equal/{columnName}")
    public List<List<Double>> threeWidthEqual(@PathVariable(value = "columnName") String columnName) throws IOException {
        return dataPreprocessService.threeEqualWidth(columnName);
    }


    /*@GetMapping("/")
    public String explain() {
        return  """
                <button id="demo">Hello Folks</button>
                <div id="result"></div>


                <script>
                    var button = document.getElementById("demo");
                    var result = document.getElementById("result");
                    button.addEventListener("click", function(){
                        fetch('http://localhost:8080/three-width-equal/Age')
                        .then(res => res.json())
                        .then(data => {
                            result.innerText = JSON.stringify(data);
                        })
                        .catch(err => console.log(err))
                    })
                </script>

                """;
    }

    public String buttonClick() {
        return "Selam";
    }*/

    @GetMapping("/")
    public String explain() {
        return """
                <head>
                    <meta charset="UTF-8">
                    <title>Veri Onisleme Teknikleri</title>
                </head>
                <body>
                                
                <table>
                    <tr>
                        <td>INSU</td>
                    </tr>
                    <tr>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/average/Insu">Average</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/mode/Insu">Mod</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/standartDeviation/Insu">Standart Sapma</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/five-number-summary/Insu">Beş Sayı Özeti</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/iqr/Insu">IQR</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/min-max-normalization/Insu">Min-Max Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/z-score-normalization/Insu">Z Score Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/three-width-equal/Insu">3 Equal Width</a>
                            </button>
                        </td>
                    </tr>
                </table>
                          
                <hr>      
                <br><br>
                                
                <table>
                    <tr>
                        <td>Mass</td>
                    </tr>
                    <tr>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/average/Mass">Average</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/mode/Mass">Mod</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/standartDeviation/Mass">Standart Sapma</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/five-number-summary/Mass">Beş Sayı Özeti</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/iqr/Mass">IQR</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/min-max-normalization/Mass">Min-Max Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/z-score-normalization/Mass">Z Score Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/three-width-equal/Mass">3 Equal Width</a>
                            </button>
                        </td>
                    </tr>
                </table>
                    
                <hr>                
                <br><br>
                                
                <table>
                    <tr>
                        <td>Pedi</td>
                    </tr>
                    <tr>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/average/Pedi">Average</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/mode/Pedi">Mod</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/standartDeviation/Pedi">Standart Sapma</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/five-number-summary/Pedi">Beş Sayı Özeti</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/iqr/Pedi">IQR</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/min-max-normalization/Pedi">Min-Max Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/z-score-normalization/Pedi">Z Score Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/three-width-equal/Pedi">3 Equal Width</a>
                            </button>
                        </td>
                    </tr>
                </table>
                 
                <hr>               
                <br><br>
                                
                <table>
                    <tr>
                        <td>Age</td>
                    </tr>
                    <tr>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/average/Age">Average</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/mode/Age">Mod</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/standartDeviation/Age">Standart Sapma</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/five-number-summary/Age">Beş Sayı Özeti</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/iqr/Age">IQR</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/min-max-normalization/Age">Min-Max Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/z-score-normalization/Age">Z Score Normalization</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="https://data-preporessor-techniques.herokuapp.com/data-preprocessor-techniques/data-preprocessor-techniques/three-width-equal/Age">3 Equal Width</a>
                            </button>
                        </td>
                    </tr>
                </table>
                                
                </body>
                                
                """;
    }


}
