// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyD4NZV1y1lx1yWTMoe3_jBsl4uj5vhs5dg",
  authDomain: "home-automation-e22cc.firebaseapp.com",
  projectId: "home-automation-e22cc",
  storageBucket: "home-automation-e22cc.firebasestorage.app",
  messagingSenderId: "1012755480088",
  appId: "1:1012755480088:web:749fb23ee9a9b501658d6d",
  measurementId: "G-NJJEFBCD6Q"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);