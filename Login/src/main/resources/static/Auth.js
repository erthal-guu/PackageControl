document.getElementById("formLogin").addEventListener("submit", async function (event) {
    event.preventDefault(); // evita reload

    const cpf = document.getElementById("cpf").value;
    const senha = document.getElementById("senha").value;

    try {
        const response = await fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                cpf: cpf,
                senha: senha
            })
        });

        if (response.status === 200) {
            const usuario = await response.json();
            alert("Login realizado com sucesso!");

            // Redirecionar
            window.location.href = "home.html";
        } else if (response.status === 401) {
            alert("CPF ou senha incorretos!");
        } else {
            alert("Erro inesperado no servidor!");
        }

    } catch (error) {
        console.error("Erro:", error);
        alert("Não foi possível conectar ao servidor.");
    }
});
