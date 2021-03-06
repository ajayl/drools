/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.models.guided.dtree.shared.model.values.impl;

import org.drools.workbench.models.datamodel.util.PortablePreconditions;
import org.drools.workbench.models.guided.dtree.shared.model.values.Value;

public class DoubleValue implements Value<Double> {

    private Double value;

    public DoubleValue() {
        //Errai marshalling
    }

    public DoubleValue( final Double value ) {
        setValue( value );
    }

    public DoubleValue( final DoubleValue value ) {
        setValue( value.getValue() );
    }

    @Override
    public void setValue( final String value ) {
        try {
            setValue( new Double( value ) );
        } catch ( NumberFormatException nfe ) {
            setValue( new Double( 0 ) );
        }
    }

    @Override
    public void setValue( final Double value ) {
        this.value = PortablePreconditions.checkNotNull( "value",
                                                         value );
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof DoubleValue ) ) {
            return false;
        }

        DoubleValue that = (DoubleValue) o;

        if ( !value.equals( that.value ) ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
