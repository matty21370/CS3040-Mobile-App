const express = require('express');
const app = express();
const mongoose = require('mongoose');

require('dotenv').config();

mongoose.connect(process.env.DB_CONNECT, () => {
    console.log("Connected to database");
});

const authRoute = require('./router/auth');

app.use(express.json());

app.use('/api', authRoute);

app.listen(3000, () => {
    console.log("Server running");
})