// formatear los numeros con separador de miles y decimales y signo $
function formatNumber(num) {
    return "$" + num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.')


}

window.onload = function() {
    let montos = document.getElementsByClassName("monto")
    for (let i = 0; i < montos.length; i++) {
        montos[i].innerHTML = formatNumber(montos[i].innerHTML)

    }

}

