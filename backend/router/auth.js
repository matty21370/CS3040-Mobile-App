const router = require('express').Router();
const User = require('../model/user');

router.get('/test', (req, res) => {
    res.send("Hello");
});

router.post('/register', (req, res) => {
    const user = new User({
        username: req.body.username,
        password: req.body.password
    });

    try {
        user.save();
        res.send(user);
    } catch {
        res.sendStatus(400);
    }
});

module.exports = router;