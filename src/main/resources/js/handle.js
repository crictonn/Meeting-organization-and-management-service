import Head from "next/head";
import { useRouter } from 'next/router'
import { useState } from "react";

export default function SignIn(){
    var button = document.getElementById("signInButton");
    button.addEventListener("click", handle)
    const router = useRouter()

    const [state, setState] = useState({
        username: "",
        password: ""
    })

    function fill(e){
        const copy = {...state}
        copy[e.target.name] = e.target.value
        setState(copy)
    }

    async function handle(){
        localStorage.clear()
        const res = await fetch('http://localhost:8080/auth/signin', {
            method: "POST",
            body: JSON.stringify(state),
            headers: {
                "Content-type": "application/json"
            }
        })
        if(res.ok){
            const json = await res.text()
            console.log(json)
            localStorage.setItem("token", json)
            router.push("/")
        }
    }

    // return(
    //     <>
    //         <Head>
    //             <title>Sign in</title>
    //             <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    //         </Head>
    //         <div>
    //             <div>
    //                 <h1>Sign in</h1>
    //                 <div>
    //                     <input type="text" name= "username" placeholder="username" autoComplete="off" />
    //                 </div>
    //                 <div>
    //                     <input type="password" name= "password" placeholder="password"/>
    //                 </div>
    //                 <button onClick={handle}>Submit</button>
    //
    //             </div>
    //         </div>
    //     </>
    // )
}