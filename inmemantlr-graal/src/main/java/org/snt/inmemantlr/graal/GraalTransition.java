/**
 * Inmemantlr - In memory compiler for Antlr 4
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Julian Thome <julian.thome.de@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
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
 **/

package org.snt.inmemantlr.graal;

import org.jgrapht.graph.DefaultEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraalTransition extends DefaultEdge {

    final static Logger LOGGER = LoggerFactory.getLogger(GraalTransition.class);


    private GraalState src;
    private GraalState tar;


    public GraalTransition(GraalState src, GraalState tar) {
        this.src = src;
        this.tar = tar;

    }

    @Override
    public GraalState getSource() {
        return this.src;
    }

    @Override
    public GraalState getTarget() {
        return this.tar;
    }

    public GraalTransition clone() {
        return new GraalTransition(src.clone(), tar.clone());
    }


    @Override
    public boolean equals(Object o) {

        if(!(o instanceof GraalTransition)) {
            return false;
        }
        GraalTransition t = (GraalTransition)o;
        return src.equals(t.src) && tar.equals(t.tar);
    }

    @Override
    public int hashCode() {
        int hc = 0;
        hc = 37 * hc + src.hashCode();
        return 37 * hc + tar.hashCode();
    }

    public String toDot() {
        return "";
    }


}
