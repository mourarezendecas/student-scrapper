import com.mourarezendecas.contentreader.ContentHelper
import spock.lang.Specification

class ContentHelperSpec extends Specification{
    void 'testa conteudo extraido'(){
        when:
        String resultadoEsperado= """
<!doctype HTML public "-//W3C//DTD HTML 4.0 Frameset//EN">

</html>
"""
        String resultadoObtido = ContentHelper.lerConteudo('src/test/resources/pagina.txt')
        then:
        resultadoObtido == resultadoEsperado
    }


}
