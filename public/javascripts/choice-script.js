$(document).ready(function() {

    /* esconde os botões ainda não clicados */
    $('#mostra-anuncio-vocais').hide();
    $('#mostra-anuncio-cordas').hide();
    $('#mostra-anuncio-percussao').hide();
    $('#mostra-anuncio-eletronico').hide();

    /* mostra apenas anuncios mais recentes */
    $('a#clica-mais').click(function(){
        $('#mostra-anuncio').show();
        $('#mostra-anuncio-vocais').hide();
        $('#mostra-anuncio-cordas').hide();
        $('#mostra-anuncio-percussao').hide();
        $('#mostra-anuncio-eletronico').hide();
    });

    /* mostra apenas anuncios com reverencias vocais */
    $('a#clica-voz').click(function(){
        $('#mostra-anuncio').hide();
        $('#mostra-anuncio-vocais').show();
        $('#mostra-anuncio-cordas').hide();
        $('#mostra-anuncio-percussao').hide();
        $('#mostra-anuncio-eletronico').hide();
    });

    /* mostra apenas anuncios com reverencias a cordas */
    $('a#clica-cordas').click(function(){
        $('#mostra-anuncio').hide();
        $('#mostra-anuncio-vocais').hide();
        $('#mostra-anuncio-cordas').show();
        $('#mostra-anuncio-percussao').hide();
        $('#mostra-anuncio-eletronico').hide();
    });

    /* mostra apenas anuncios com reverencias a percussao */
    $('a#clica-percussao').click(function(){
        $('#mostra-anuncio').hide();
        $('#mostra-anuncio-vocais').hide();
        $('#mostra-anuncio-cordas').hide();
        $('#mostra-anuncio-percussao').show();
        $('#mostra-anuncio-eletronico').hide();
    });


    /* mostra apenas anuncios com reverencias a musica eletronica */
    $('a#clica-eletronico').click(function(){
        $('#mostra-anuncio').hide();
        $('#mostra-anuncio-vocais').hide();
        $('#mostra-anuncio-cordas').hide();
        $('#mostra-anuncio-percussao').hide();
        $('#mostra-anuncio-eletronico').show();
    });

});