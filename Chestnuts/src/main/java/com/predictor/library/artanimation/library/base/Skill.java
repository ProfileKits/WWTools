/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.predictor.library.artanimation.library.base;

import com.predictor.library.artanimation.library.base.back.BackEaseIn;
import com.predictor.library.artanimation.library.base.back.BackEaseInOut;
import com.predictor.library.artanimation.library.base.back.BackEaseOut;
import com.predictor.library.artanimation.library.base.bounce.BounceEaseIn;
import com.predictor.library.artanimation.library.base.bounce.BounceEaseInOut;
import com.predictor.library.artanimation.library.base.bounce.BounceEaseOut;
import com.predictor.library.artanimation.library.base.circ.CircEaseIn;
import com.predictor.library.artanimation.library.base.circ.CircEaseInOut;
import com.predictor.library.artanimation.library.base.circ.CircEaseOut;
import com.predictor.library.artanimation.library.base.cubic.CubicEaseIn;
import com.predictor.library.artanimation.library.base.cubic.CubicEaseInOut;
import com.predictor.library.artanimation.library.base.cubic.CubicEaseOut;
import com.predictor.library.artanimation.library.base.elastic.ElasticEaseIn;
import com.predictor.library.artanimation.library.base.elastic.ElasticEaseOut;
import com.predictor.library.artanimation.library.base.expo.ExpoEaseIn;
import com.predictor.library.artanimation.library.base.expo.ExpoEaseInOut;
import com.predictor.library.artanimation.library.base.expo.ExpoEaseOut;
import com.predictor.library.artanimation.library.base.linear.Linear;
import com.predictor.library.artanimation.library.base.quad.QuadEaseIn;
import com.predictor.library.artanimation.library.base.quad.QuadEaseInOut;
import com.predictor.library.artanimation.library.base.quad.QuadEaseOut;
import com.predictor.library.artanimation.library.base.quint.QuintEaseIn;
import com.predictor.library.artanimation.library.base.quint.QuintEaseInOut;
import com.predictor.library.artanimation.library.base.quint.QuintEaseOut;
import com.predictor.library.artanimation.library.base.sine.SineEaseIn;
import com.predictor.library.artanimation.library.base.sine.SineEaseInOut;
import com.predictor.library.artanimation.library.base.sine.SineEaseOut;


public enum  Skill {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);


    private Class easingMethod;

    private Skill(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
