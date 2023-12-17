import { useRouter } from 'next/router'
import { useState } from "react";

const formElement = document.getElementById("signinForm");
formElement.addEventListener('submit', async (e) => {
    e.preventDefault();
    const router = useRouter()
    const formData = new FormData(formElement);
    const username = formData.get('username');
    const password = formData.get('inputPassword');

    const [state, setState] = useState({
        username: username,
        password: password
    })

    localStorage.clear()
    const res = await fetch('http://localhost:8080/auth/signin', {
        method: "POST",
        body: JSON.stringify(state),
        headers: {
            "Content-type": "application/json"
        }
    })
    if (res.ok) {
        const json = await res.text()
        console.log(json)
        localStorage.setItem("token", json)
        router.push("/")
    }
});